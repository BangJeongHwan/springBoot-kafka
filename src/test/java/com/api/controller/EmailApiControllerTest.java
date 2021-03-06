package com.api.controller;

import com.api.common.model.email.EmailMessageReq;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EmailApiControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void API로_이메일_발송요청_HttpStatus가_결과응답된다() throws Exception {
        EmailMessageReq message = EmailMessageReq.builder()
                .content("test")
                .fromEmail("test@naver.com")
                .memberEmail("baju92@naver.com")
                .requestDate(null)
                .sendKey("1111111")
                .sendType("MASS")
                .build();

        mvc.perform(
                post("/email/sender/mail")
                        .param("content",message.getContent())
                        .param("fromEmail", message.getFromEmail())
                        .param("memberEmail", message.getMemberEmail())
                        .param("requestDate",message.getRequestDate())
                        .param("sendKey",message.getSendKey())
                        .param("sendType",message.getSendType())
        )
                .andExpect(status().isOk())
                ;
    }
}