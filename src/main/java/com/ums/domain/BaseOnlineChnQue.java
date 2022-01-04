package com.ums.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@Slf4j
@MappedSuperclass
@Data
public class BaseOnlineChnQue implements Serializable {
	
	//요일 관련 컬럼 추가
	private String umsReserveDay;

	private String mappingType;
	private String ifId;
	private String sysCode;
	private String templateMsgId;
	private String testYn;
	private String campId;
	private String memberId;
	private String memberType;
	private String forcedSendYn;
	private String memberPhone;
	private String fromNumber;
	private String reserveDate;
	private String field1;
	private String field2;
	private String field3;
	private String field4;
	private String field5;
	private String field6;
	private String field7;
	private String field8;
	private String field9;
	private String field10;
	private String addMappingCnt;
	private String shortUrl1;
	private String longUrl1;
	private String shortUrl2;
	private String longUrl2;
	private String shortUrl3;
	private String longUrl3;
	private String shortUrl4;
	private String longUrl4;
	private String shortUrl5;
	private String longUrl5;
	
	private String subject;
	private String contents;
	private String targetFlag;
	private String serverId;
	private String pollKey;
}