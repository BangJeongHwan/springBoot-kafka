package com.ums.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
public class XmsQueDto extends BaseQueDto{

	@Schema(example = "홍길동")
	@JsonProperty("FROM_NAME")
	private String fromName;

	@Schema(hidden = true)
	@JsonProperty("SMS_TYPE")
	private String smsType;
	@Schema(hidden = true)
	@JsonProperty("KAKAO_TYPE")
	private String kakaoType;

	@Schema(hidden = true)
	@JsonProperty("TEMPLATE_CODE")
	private String templateCode;

	@Schema(hidden = true)
	@JsonProperty("SENDER_KEY")
	private String senderKey;

	@Schema(hidden = true)
	@JsonProperty("MKT_YN")
	private String mktYn;

	@JsonProperty("REG_DATE")
	private LocalDateTime regDate;

	@Schema(hidden = true)
	@JsonProperty("SMS_RDNY_YN")
	private String smsRdnyYn;

	@Schema(hidden = true)
	@JsonProperty("RPLC_TITLE")
	private String rplcTitle;

	@Schema(hidden = true)
	@JsonProperty("RPLC_CN")
	private String rplcCn;
	
}
