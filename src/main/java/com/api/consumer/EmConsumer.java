package com.api.consumer;

import com.api.common.model.AbstractMessage;
import com.api.common.model.email.EmailMessageReq;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class EmConsumer {

    private ObjectMapper mapper;

    @PostConstruct
    void init() {
        mapper = new ObjectMapper();
    }

    @KafkaListener(topics = "#{messageConfig.topics.reqEmail}")
    public void consume(
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Payload AbstractMessage message,
            Acknowledgment acknowledgment) {


        EmailMessageReq emailMessageReq;

        try {
            emailMessageReq = mapper.convertValue(message, new TypeReference<EmailMessageReq>() {});
            log.info("emailMessageReq : {}",emailMessageReq);
        }catch (Exception e){
            log.error("{}",e);
        }finally {
            acknowledgment.acknowledge();
        }
    }
}
