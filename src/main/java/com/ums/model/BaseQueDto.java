package com.ums.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class BaseQueDto {

  @Schema(hidden = true)
  @JsonProperty("CHANNEL_TYPE")
  private String channelType;

  @Schema(hidden = true)
  @JsonProperty("CONTENT")
  private String content;

  @Schema(hidden = true)
  @JsonProperty("CONTENT_TYPE")
  private String contentType;

  @Schema(hidden = true)
  @JsonProperty("SUBJECT")
  private String subject;

  // 피로도 필터링 플래그  FILTER_USE_YN
  @Schema(defaultValue = "N")
  @JsonProperty("FILTER_USE_YN")
  private String filterUseYn;

  // 롯데카드 추가
  @Schema(hidden = true)
  @JsonProperty("QUEUE_ID")
  private long queueId;
  @Schema(hidden = true)
  @JsonProperty("INFO_ID")
  private long infoId;
  @Schema(example = "20220114160000")
  @JsonProperty("IF_ID")
  private String ifId;

  @Schema(description = "고객 ID", example = "baju92")
  @JsonProperty("MEMBER_ID")
  private String memberId;

  @Schema(example = "01")
  @JsonProperty("MEMBER_TYPE")
  private String memberType;
  @Schema(defaultValue = "N")
  @JsonProperty("FORCED_SEND_YN")
  private String forcedSendYn;
  @Schema(example = "01012345678")
  @JsonProperty("MEMBER_PHONE")
  private String memberPhone;

  @Schema(example = "0212345678")
  @JsonProperty("FROM_NUMBER")
  private String fromNumber;

  @Schema(hidden = true)
  @JsonProperty("SEND_TYPE")
  private String sendType;
  
  // 테스트 발송 처리
  @Schema(defaultValue = "N")
  @JsonProperty("TEST_YN")
  private String testYn;

  @Schema(hidden = true)
  @JsonProperty("FIELD1")
  private String field1;

  @Schema(hidden = true)
  @JsonProperty("FIELD2")
  private String field2;

  @Schema(hidden = true)
  @JsonProperty("FIELD3")
  private String field3;

  @Schema(hidden = true)
  @JsonProperty("FIELD4")
  private String field4;

  @Schema(hidden = true)
  @JsonProperty("FIELD5")
  private String field5;

  @Schema(hidden = true)
  @JsonProperty("FIELD6")
  private String field6;

  @Schema(hidden = true)
  @JsonProperty("FIELD7")
  private String field7;

  @Schema(hidden = true)
  @JsonProperty("FIELD8")
  private String field8;

  @Schema(hidden = true)
  @JsonProperty("FIELD9")
  private String field9;

  @Schema(hidden = true)
  @JsonProperty("FIELD10")
  private String field10;

  @Schema(hidden = true)
  @JsonProperty("SHORT_URL1")
  private String shortUrl1;

  @Schema(hidden = true)
  @JsonProperty("LONG_URL1")
  private String longUrl1;

  @Schema(hidden = true)
  @JsonProperty("SHORT_URL2")
  private String shortUrl2;

  @Schema(hidden = true)
  @JsonProperty("LONG_URL2")
  private String longUrl2;

  @Schema(hidden = true)
  @JsonProperty("SHORT_URL3")
  private String shortUrl3;

  @Schema(hidden = true)
  @JsonProperty("LONG_URL3")
  private String longUrl3;

  @Schema(hidden = true)
  @JsonProperty("SHORT_URL4")
  private String shortUrl4;

  @Schema(hidden = true)
  @JsonProperty("LONG_URL4")
  private String longUrl4;

  @Schema(hidden = true)
  @JsonProperty("SHORT_URL5")
  private String shortUrl5;

  @Schema(hidden = true)
  @JsonProperty("LONG_URL5")
  private String longUrl5;

  @Schema(description = "템플릿 메시지 ID", example = "C11A211223001")
  @JsonProperty("TEMPLATE_MSG_ID")
  private String templateMsgId;

  @Schema(description = "타켓 플래그", defaultValue = "N")
  @JsonProperty("TARGET_FLAG")
  private String targetFlag;

  @Schema(hidden = true)
  @JsonProperty("SERVER_ID")
  private String serverId;

  @Schema(hidden = true)
  @JsonProperty("POLL_KEY")
  private String pollKey;


  @Schema(hidden = true)
  private String errorCode;
  @Schema(hidden = true)
  private String sendStatus;
  @Schema(hidden = true)
  @JsonProperty("ROW_ID")
  private String rowId;
  @JsonProperty("FRAME_CYCLE")
  @Schema(hidden = true)
  private String frameCycle;

  @Schema(defaultValue = "N")
  @JsonProperty("MAPPING_TYPE")
  private String mappingType;

  @Schema(description = "보내는 날짜(현재 날짜)", example = "17")
  @JsonProperty("UMS_RESERVE_DAY")
  private String umsReserveDay;
}
