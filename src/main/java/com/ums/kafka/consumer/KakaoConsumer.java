package com.ums.kafka.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tason.cmc.protocol.Packet;
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
public class KakaoConsumer {

    private ObjectMapper mapper;

    @PostConstruct
    void init() {
        mapper = new ObjectMapper();
    }

    @KafkaListener(topics = "#{umsMessageConfig.topics.reqAt}",
            containerFactory = "smtKafkaListenerContainerFactory"
    )
    public void consume(
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Payload Packet packet,
            Acknowledgment acknowledgment) {

//        EmailMessageReq emailMessageReq;

        try {
//            emailMessageReq = mapper.convertValue(message, new TypeReference<EmailMessageReq>() {});
            log.info("at pack : {}",packet);
        }catch (Exception e){
            log.error("{}",e);
        }finally {
            acknowledgment.acknowledge();
        }
    }
}
