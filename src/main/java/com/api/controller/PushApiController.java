package com.api.controller;

import com.api.common.model.push.PushMessageReq;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/push/sender/message")
public class PushApiController {

    @PostMapping
    public String sendMessage(@RequestBody PushMessageReq emailMessageReq) {


        return "success";
    }
}
