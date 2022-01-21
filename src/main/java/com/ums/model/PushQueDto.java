package com.ums.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PushQueDto extends BaseQueDto {

	@Schema(hidden = true)
	@JsonProperty("PUSH_TYPE")
	private String pushType;

	@Schema(hidden = true)
	@JsonProperty("PUSH_TITLE")
	private String pushTitle;

	@Schema(hidden = true)
	@JsonProperty("PUSH_MSG")
	private String pushMsg;

	@Schema(hidden = true)
	@JsonProperty("PUSH_KEY")
	private String pushKey;

	@Schema(hidden = true)
	@JsonProperty("PUSH_VALUE")
	private String pushValue;

	@Schema(hidden = true)
	@JsonProperty("PUSH_IMG")
	private String pushImg;

	@Schema(hidden = true)
	@JsonProperty("SPECIAL_PUSH_TYPE")
	private String specialPushType;

	@Schema(hidden = true)
	@JsonProperty("SPECIAL_PUSH_PARAM")
	private String specialPushParam;

	@Schema(hidden = true)
	@JsonProperty("TOKEN")
	private String token;

	@Schema(hidden = true)
	@JsonProperty("APP_GRP_ID")
	private int appGrpId;

	@Schema(hidden = true)
	@JsonProperty("APP_ID")
	private int appId;

	@Schema(hidden = true)
	@JsonProperty("DEVICE_ID")
	private int deviceId;

	@Schema(hidden = true)
	@JsonProperty("MKT_YN")
	private String mktYn;

	@Schema(hidden = true)
	@JsonProperty("NOTI_FLAG")
	private String notiFlag;

	@Schema(hidden = true)
	@JsonProperty("REQ_UID")
	private String reqUid;

	@Schema(hidden = true)
	@JsonProperty("CHUNK_ID")
	private String chunkId;

	@Schema(hidden = true)
	@JsonProperty("APP_OS")
	private String appOs;

	@Schema(hidden = true)
	@JsonProperty("MSG_UID")
	private String msgUid;
	
//    private InAppMsgInfoDto inAppMsgInfoDto;
	@Schema(hidden = true)
	@JsonProperty("PUSH_TTL")
    private int pushTtl;

	@Schema(hidden = true)
	@JsonProperty("PUSH_VALUES")
    private String pushValues;

	@Schema(description = "예약시간(2시간 이전 데이터까지 발송 가능)", example = "20220105110000")
	@JsonProperty("RESERVE_DATE")
    private String reserveDate;

	@Schema(hidden = true)
	@JsonProperty("PUSH_SOUND")
    private String pushSound;

	@Schema(hidden = true)
	@JsonProperty("APP_KEY")
    private String appKey;

	@Schema(hidden = true)
	@JsonProperty("MSG_TYPE")
    private String msgType;

	@Schema(hidden = true)
	@JsonProperty("INAPP_CONTENT")
    private String inappContent;
    
    // hist 적재를 위해서 tms_push_que 에 적재하려고 하는데 필요한 코드
	@Schema(hidden = true)
	@JsonProperty("TRANS_CODE")
    private String transCode;


	@Schema(hidden = true)
	@JsonProperty("INAPP_URL")
    private String inappUrl;

	@Schema(hidden = true)
	@JsonProperty("BUTTON_NAME")
    private String buttonName;

	@Schema(hidden = true)
	@JsonProperty("CATEGORY_CODE")
    private String categoryCode;

}
