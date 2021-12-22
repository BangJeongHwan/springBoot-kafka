package com.api.service;

import com.api.common.model.AbstractMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.PostConstruct;

@Service
public class KafkaService {

    @PostConstruct
    public void init() {
        mapper = new ObjectMapper();
    }

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private ObjectMapper mapper;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendToKafka(String topic, AbstractMessage message) throws JsonProcessingException {
        final String data;

        try {
            data = mapper.writeValueAsString(message);
        } catch (JsonProcessingException e) {
            throw e;
        }

        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, data);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
            }

            @Override
            public void onFailure(Throwable e) {
                logger.error("kafka send failed. topic: {}, data: {}", topic, data, e.getCause());
            }
        });
    }

}
