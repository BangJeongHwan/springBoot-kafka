package com.ums.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
public class XmsQueDto extends BaseQueDto{
	@JsonProperty("CHANNEL_TYPE")
	private String channelType;
	
	@JsonProperty("CONTENT")
	private String content;

	@JsonProperty("CONTENT_TYPE")
	private String contentType;
	
	@JsonProperty("SUBJECT")
	private String subject;

	@JsonProperty("FROM_NAME")
	private String fromName;
	@JsonProperty("SMS_TYPE")
	private String smsType;
	@JsonProperty("KAKAO_TYPE")
	private String kakaoType;
	
	@JsonProperty("TEMPLATE_CODE")
	private String templateCode;
	@JsonProperty("SENDER_KEY")
	private String senderKey;
	@JsonProperty("MKT_YN")
	private String mktYn;
	
	// 피로도 필터링 플래그  FILTER_USE_YN
	@JsonProperty("FILTER_USE_YN")
	private String filterUseYn;

	@JsonProperty("REG_DATE")
	private LocalDateTime regDate;
	
	private String rowId;
	private String frameCycle;
	
	@JsonProperty("SMS_RDNY_YN")
	private String smsRdnyYn;
	
	@JsonProperty("RPLC_TITLE")
	private String rplcTitle;
	
	@JsonProperty("RPLC_CN")
	private String rplcCn;
	
}
