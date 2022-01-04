package com.api.consumer;

import com.api.common.model.AbstractMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class PuConsumer {

    private ObjectMapper mapper;

    @PostConstruct
    void init() {
        mapper = new ObjectMapper();
    }

    @KafkaListener(topics = "#{messageConfig.topics.reqPush}",
            containerFactory = "puKafkaListenerContainerFactory"
    )
    public void consume(
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Payload AbstractMessage message,
            Acknowledgment acknowledgment) {


//        EmailMessageReq emailMessageReq;

        try {
//            emailMessageReq = mapper.convertValue(message, new TypeReference<EmailMessageReq>() {});
            log.info("pu message : {}",message);
        }catch (Exception e){
            log.error("{}",e);
        }finally {
            acknowledgment.acknowledge();
        }
    }
}
