package com.ums.controller;

import com.ums.model.online.OnlinePushQueDto;
import com.ums.model.online.OnlineXmsQueDto;
import com.ums.service.TasonIntegrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Tag(name = "온라인 발송 QUE API", description = "인테그레이션 온라인 발송 QUE 적재")
@RequiredArgsConstructor
@RestController
@RequestMapping("/integration/send")
public class TasonIntegrationController {

    private final TasonIntegrationService tasonIntegrationService;

    @Operation(summary = "온라인 XMS QUE 적재")
    @PostMapping("/online/xms")
    public HttpStatus onlineXmsQue(@RequestBody OnlineXmsQueDto dto){

        try {
            log.info(dto.toString());
            tasonIntegrationService.insertOnlineXmsQue(dto);
        } catch (Exception e) {
            log.error("Send message error : {}",e);
            return HttpStatus.BAD_REQUEST;
        } finally {
            return HttpStatus.OK;
        }
    }

    @Operation(summary = "온라인 PUSH QUE 적재")
    @PostMapping("/online/push")
    public HttpStatus onlinePushQue(@RequestBody OnlinePushQueDto dto){

        try {
            log.info(dto.toString());
            tasonIntegrationService.insertOnlinePushQue(dto);
        } catch (Exception e) {
            log.error("Send message error : {}",e);
            return HttpStatus.BAD_REQUEST;
        } finally {
            return HttpStatus.OK;
        }
    }
}
