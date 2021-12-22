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
        EmailMessageReq message = new EmailMessageReq();
        message.setContent("test");
        message.setFromEmail("test@naver.com");
        message.setMemberEmail("baju92@naver.com");
        message.setRequestDate(null);
        message.setSendKey("1111111");
        message.setSendType("MASS");

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