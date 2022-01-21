package com.ums.kafka.config;

import com.tason.cmc.protocol.Packet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.adapter.RetryingMessageListenerAdapter;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableKafka
public class ConsumerConfig {

    private final KafkaProperties kafkaProperties;

    @Value("${spring.kafka.retry.max-attempts}")
    private int retryMaxAttempts;
    @Value("${spring.kafka.retry.initial-interval}")
    private int retryInitialInterval;
    @Value("${spring.kafka.retry.multiplier}")
    private int retryMultiplier;
    @Value("${spring.kafka.retry.max-interval}")
    private int retryMaxInterval;

    /** SMS listener config */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, Packet> smtKafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, Packet> factory = new ConcurrentKafkaListenerContainerFactory<>();

        // 오프셋 커밋 동작 제어
        // MANUAL_IMMEDIATE : 리스너 스레드에서 ack가 수행되는 한 오프셋이 즉시 커밋
        factory.getContainerProperties().setAckMode(kafkaProperties.getListener().getAckMode());
        // 컨슘 폴링 타임 제어
        factory.getContainerProperties().setPollTimeout(kafkaProperties.getListener().getPollTimeout().toMillis());

        // Container 동시 처리 갯수
        factory.setConcurrency(kafkaProperties.getListener().getConcurrency());
        // retry 예외 발생시 errorHandler 호출
//        factory.setErrorHandler(new KafkaErrorHandler());

        factory.setStatefulRetry(true);
        factory.setBatchListener(false);
        factory.setConsumerFactory(smtConsumerFactory());
        factory.setRetryTemplate(retryTemplate());

        factory.setRecoveryCallback(retryContext -> {
            Throwable lastThrowable = retryContext.getLastThrowable();
            ConsumerRecord<String, String> record = (ConsumerRecord<String, String>) retryContext.getAttribute(RetryingMessageListenerAdapter.CONTEXT_RECORD);
            Acknowledgment acknowledgment = (Acknowledgment) retryContext.getAttribute(RetryingMessageListenerAdapter.CONTEXT_ACKNOWLEDGMENT);

            log.error("error received message='{}' with partition-offset='{}', key='{}'", record.value(), record.partition(), record.key(), lastThrowable);

            acknowledgment.acknowledge();

            return null;
        });
        return factory;
    }

    /** EM consumer config */
    @Bean
    public ConsumerFactory<String, Packet> smtConsumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
        JsonDeserializer<Packet> jsonDeserializer = new JsonDeserializer<>(Packet.class);
        jsonDeserializer.setRemoveTypeHeaders(false);
        jsonDeserializer.addTrustedPackages("*");
        jsonDeserializer.setUseTypeMapperForKey(true);
        return new DefaultKafkaConsumerFactory<>(smtConsumerConfigs(jsonDeserializer), new StringDeserializer(), jsonDeserializer);
    }

    public Map<String, Object> smtConsumerConfigs(JsonDeserializer<Packet> jsonDeserializer) {
        Map<String, Object> props = new HashMap<>();
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, jsonDeserializer);
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.GROUP_ID_CONFIG, kafkaProperties.getConsumer().getGroupId());
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, kafkaProperties.getConsumer().getEnableAutoCommit());
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.MAX_POLL_RECORDS_CONFIG, kafkaProperties.getConsumer().getMaxPollRecords());
        props.put(org.apache.kafka.clients.consumer.ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, kafkaProperties.getConsumer().getAutoOffsetReset());
        return props;
    }

    protected RetryPolicy retryPolicy() {
        SimpleRetryPolicy policy = new SimpleRetryPolicy();
        policy.setMaxAttempts(retryMaxAttempts);
        return policy;
    }

    protected BackOffPolicy backOffPolicy() {
        ExponentialBackOffPolicy policy = new ExponentialBackOffPolicy();
        policy.setInitialInterval(retryInitialInterval);
        policy.setMultiplier(retryMultiplier);
        policy.setMaxInterval(retryMaxInterval);
        return policy;
    }

    protected RetryTemplate retryTemplate() {
        RetryTemplate template = new RetryTemplate();

        template.setRetryPolicy(retryPolicy());
        template.setBackOffPolicy(backOffPolicy());

        return template;
    }
}
