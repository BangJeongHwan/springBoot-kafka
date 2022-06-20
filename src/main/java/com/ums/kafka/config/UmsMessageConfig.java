package com.ums.kafka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "ums.server", ignoreUnknownFields = true)
public class UmsMessageConfig {

    // kafka topic 설정
    private Topics topics = new Topics();

    /**
     * Kafka topic 설정
     */
    @Data
    public static class Topics {

        // 알림톡 수신 topic list
        private List<String> reqAt;

        // 친구톡 수신 topic list
        private List<String> reqFt;

        // SMS MT 수신 topic list
        private List<String> reqSmt;

        // LMS MT 수신 topic list
        private List<String> reqLmt;

        // MMT MT 수신 topic list
        private List<String> reqMmt;

        // Push 수신 topic list
        private List<String> reqPush;

        // Email 수신 topic list
        private List<String> reqEmail;

    }
}
