package com.ums.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class PushQueDto extends BaseQueDto {

	@JsonProperty("CHANNEL_TYPE")
	private String channelType;
	@JsonProperty("CONTENT")
	private String content;
	@JsonProperty("CONTENT_TYPE")
	private String contentType;
	@JsonProperty("SUBJECT")
	private String subject;
	@JsonProperty("PUSH_TYPE")
	private String pushType;
	@JsonProperty("PUSH_TITLE")
	private String pushTitle;
	@JsonProperty("PUSH_MSG")
	private String pushMsg;
	@JsonProperty("PUSH_KEY")
	private String pushKey;
	@JsonProperty("PUSH_VALUE")
	private String pushValue;
	@JsonProperty("PUSH_IMG")
	private String pushImg;
	@JsonProperty("SPECIAL_PUSH_TYPE")
	private String specialPushType;
	@JsonProperty("SPECIAL_PUSH_PARAM")
	private String specialPushParam;
	@JsonProperty("TOKEN")
	private String token;
	@JsonProperty("APP_GRP_ID")
	private int appGrpId;
	@JsonProperty("APP_ID")
	private int appId;
	@JsonProperty("DEVICE_ID")
	private int deviceId;
	@JsonProperty("MKT_YN")
	private String mktYn;
	
	// 피로도 필터링 플래그  FILTER_USE_YN
	@JsonProperty("FILTER_USE_YN")
	private String filterUseYn;

	@JsonProperty("NOTI_FLAG")
	private String notiFlag;
	@JsonProperty("REQ_UID")
	private String reqUid;
	@JsonProperty("CHUNK_ID")
	private String chunkId;
	@JsonProperty("APP_OS")
	private String appOs;
	@JsonProperty("MSG_UID")
	private String msgUid;
	
//    private InAppMsgInfoDto inAppMsgInfoDto;
	@JsonProperty("ROW_ID")
    private String rowId;
	@JsonProperty("FRAME_CYCLE")
    private String frameCycle;
	@JsonProperty("PUSH_TTL")
    private int pushTtl;
	@JsonProperty("PUSH_VALUES")
    private String pushValues;
	@JsonProperty("RESERVE_DATE")
    private String reserveDate;

	@JsonProperty("PUSH_SOUND")
    private String pushSound;
	@JsonProperty("APP_KEY")
    private String appKey;

	@JsonProperty("MSG_TYPE")
    private String msgType;
	@JsonProperty("INAPP_CONTENT")
    private String inappContent;
    
    // hist 적재를 위해서 tms_push_que 에 적재하려고 하는데 필요한 코드
	@JsonProperty("TRANS_CODE")
    private String transCode;


	@JsonProperty("INAPP_URL")
    private String inappUrl;
	@JsonProperty("BUTTON_NAME")
    private String buttonName;

	@JsonProperty("CATEGORY_CODE")
    private String categoryCode;

}
