package com.api.common.config;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
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
