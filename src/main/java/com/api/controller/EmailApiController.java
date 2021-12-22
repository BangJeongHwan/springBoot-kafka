package com.api.controller;

import com.api.common.config.MessageConfig;
import com.api.common.model.email.EmailMessageReq;
import com.api.common.util.CommonGenerator;
import com.api.service.KafkaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/email/sender/mail")
public class EmailApiController {

    private final MessageConfig config;
    private final KafkaService kafkaService;


    @PostMapping
    public HttpStatus sendMessage(@RequestBody EmailMessageReq message) {

        try {
            String emailTopic = CommonGenerator.getRoundRobinListValue(CommonGenerator.GeneratorKey.SEND_EMAIL, config.getTopics().getReqEmail());
            kafkaService.sendToKafka(emailTopic, message);
            log.info("Sending a message to Kafka. topic : {}, S/N : {}", emailTopic, message.getSendKey());
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
