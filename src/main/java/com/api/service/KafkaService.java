package com.api.service;

import com.api.common.model.AbstractMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PostConstruct;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaService {

    @PostConstruct
    public void init() {
        mapper = new ObjectMapper();
    }

    private final KafkaTemplate<String, AbstractMessage> kafkaTemplate;

    private ObjectMapper mapper;

    public void sendToKafka(String topic, AbstractMessage message) throws JsonProcessingException {
        // props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);  설정
        /*
        final String data;
        try {
            data = mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw e;
        }
        */

        Message<AbstractMessage> msg = MessageBuilder
                .withPayload(message)
                .setHeader(KafkaHeaders.TOPIC, topic)
                .build();

        ListenableFuture<SendResult<String, AbstractMessage>> future = kafkaTemplate.send(msg);
        future.addCallback(new ListenableFutureCallback<SendResult<String, AbstractMessage>>() {
            @Override
            public void onSuccess(SendResult<String, AbstractMessage> result) {
                log.info("kafka send success toString : {}",result.toString());
            }

            @Override
            public void onFailure(Throwable e) {
                log.error("kafka send failed. topic: {}, data: {}", topic, message, e.getCause());
            }
        });
    }

}
