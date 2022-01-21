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
public class PushConsumer {

    private ObjectMapper mapper;

    @PostConstruct
    void init() {
        mapper = new ObjectMapper();
    }

    @KafkaListener(topics = "#{umsMessageConfig.topics.reqPush}",
            containerFactory = "smtKafkaListenerContainerFactory"
    )
    public void consume(
            @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
            @Payload Packet packet,
            Acknowledgment acknowledgment) {

//        EmailMessageReq emailMessageReq;

        try {
//            emailMessageReq = mapper.convertValue(message, new TypeReference<EmailMessageReq>() {});
            log.info("push pack : {}",packet);
        }catch (Exception e){
            log.error("{}",e);
        }finally {
            acknowledgment.acknowledge();
        }
    }
}
