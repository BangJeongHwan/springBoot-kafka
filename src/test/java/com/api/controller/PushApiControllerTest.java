package com.api.controller;

import com.api.common.model.push.PushMessageReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PushApiControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void API로_푸시_발송요청_HttpStatus가_결과응답된다() throws Exception {
        PushMessageReq message = PushMessageReq.builder()
                .appKey("appKey")
                .pushChnType("APNS")
                .title("baju92@naver.com")
                .body("푸시 내용")
                .inappMsg("앱내 메시지")
                .pushType("T")
                .requestDate(null)
                .token("token")
                .sendKey("22222")
                .build();

        mvc.perform(
                    post("/push/sender/message")
                            .param("appKey",message.getAppKey())
                            .param("pushChnType", message.getPushChnType())
                            .param("title", message.getTitle())
                            .param("body",message.getBody())
                            .param("inappMsg",message.getInappMsg())
                            .param("pushType",message.getPushType())
                            .param("token",message.getToken())
                            .param("sendKey",message.getSendKey())
            )
            .andExpect(status().isOk())
        ;
    }
}