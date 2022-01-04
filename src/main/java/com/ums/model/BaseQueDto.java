package com.ums.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BaseQueDto {

  // 롯데카드 추가
  @JsonProperty("QUEUE_ID")
  private long queueId;
  @JsonProperty("INFO_ID")
  private long infoId;
  @JsonProperty("IF_ID")
  private String ifId;
  @JsonProperty("MEMBER_ID")
  private String memberId;
  @JsonProperty("MEMBER_TYPE")
  private String memberType;
  @JsonProperty("FORCED_SEND_YN")
  private String forcedSendYn;
  @JsonProperty("MEMBER_PHONE")
  private String memberPhone;
  
  @JsonProperty("FROM_NUMBER")
  private String fromNumber;

  @JsonProperty("SEND_TYPE")
  private String sendType;
  
  // 테스트 발송 처리
  @JsonProperty("TEST_YN")
  private String testYn;
  
  @JsonProperty("FIELD1")
  private String field1;
  
  @JsonProperty("FIELD2")
  private String field2;
  
  @JsonProperty("FIELD3")
  private String field3;
  
  @JsonProperty("FIELD4")
  private String field4;
  
  @JsonProperty("FIELD5")
  private String field5;
  
  @JsonProperty("FIELD6")
  private String field6;
  
  @JsonProperty("FIELD7")
  private String field7;
  
  @JsonProperty("FIELD8")
  private String field8;
  
  @JsonProperty("FIELD9")
  private String field9;
  
  @JsonProperty("FIELD10")
  private String field10;
  
  @JsonProperty("SHORT_URL1")
  private String shortUrl1;
  
  @JsonProperty("LONG_URL1")
  private String longUrl1;
  
  @JsonProperty("SHORT_URL2")
  private String shortUrl2;
  
  @JsonProperty("LONG_URL2")
  private String longUrl2;
  
  @JsonProperty("SHORT_URL3")
  private String shortUrl3;
  
  @JsonProperty("LONG_URL3")
  private String longUrl3;
  
  @JsonProperty("SHORT_URL4")
  private String shortUrl4;
  
  @JsonProperty("LONG_URL4")
  private String longUrl4;
  
  @JsonProperty("SHORT_URL5")
  private String shortUrl5;
  
  @JsonProperty("LONG_URL5")
  private String longUrl5;

  @JsonProperty("TEMPLATE_MSG_ID")
  private String templateMsgId;
  @JsonProperty("TARGET_FLAG")
  private String targetFlag;
  @JsonProperty("SERVER_ID")
  private String serverId;
  @JsonProperty("POLL_KEY")
  private String pollKey;
  

  private String errorCode;
  private String sendStatus;
  
  private String appOs;

  @JsonProperty("MAPPING_TYPE")
  private String mappingType;
  @JsonProperty("UMS_RESERVE_DAY")
  private String umsReserveDay;
}
