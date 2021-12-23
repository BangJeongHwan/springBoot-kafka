package com.api.common.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.adapter.RetryingMessageListenerAdapter;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.retry.RetryPolicy;
import org.springframework.retry.backoff.BackOffPolicy;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Slf4j
@RequiredArgsConstructor
@Configuration
@EnableKafka
public class KafkaConfig {

    private final KafkaProperties kafkaProperties;

    @Value("${spring.kafka.retry.max-attempts}")
    private int retryMaxAttempts;
    @Value("${spring.kafka.retry.initial-interval}")
    private int retryInitialInterval;
    @Value("${spring.kafka.retry.multiplier}")
    private int retryMultiplier;
    @Value("${spring.kafka.retry.max-interval}")
    private int retryMaxInterval;

    /** producer config */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties());
    }

    /** listener config */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(ConsumerFactory<String, String> consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();

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
        factory.setConsumerFactory(consumerFactory);
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

    /** consumer config */
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
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
