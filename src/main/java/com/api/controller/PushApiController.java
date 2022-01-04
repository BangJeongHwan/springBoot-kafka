package com.api.controller;

import com.api.common.config.MessageConfig;
import com.api.common.model.push.PushMessageReq;
import com.api.common.util.CommonGenerator;
import com.api.service.KafkaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/push/sender/message")
public class PushApiController {

    private final MessageConfig config;
    private final KafkaService kafkaService;

    @PostMapping
    public HttpStatus sendMessage(@RequestBody PushMessageReq message){

        try {
            String pushTopic = CommonGenerator.getRoundRobinListValue(CommonGenerator.GeneratorKey.SEND_PUSH, config.getTopics().getReqPush());
            kafkaService.sendToKafka(pushTopic, message);
            log.info("Sending a message to Kafka. topic : {}, S/N : {}", pushTopic, message.getSendKey());
        } catch (JsonProcessingException e) {
            log.error("Send message json parsing error");
            return HttpStatus.BAD_REQUEST;
        } catch (Exception e) {
            log.error("Send message error : {}",e);
            return HttpStatus.BAD_REQUEST;
        } finally {
        }
        return HttpStatus.OK;
    }
}
