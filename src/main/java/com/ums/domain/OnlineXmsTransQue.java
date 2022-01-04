package com.ums.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;
import java.io.Serializable;


@Slf4j
@Data
@Entity
@EqualsAndHashCode(callSuper=true)
@Table(name="UMS_ONLINE_XMS_TRANS_QUEUE")
public class OnlineXmsTransQue extends BaseOnlineChnQue implements Serializable{
	
	@Id
    @Column(name="XMS_QUEUE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long queueId;
	
    public OnlineSmsTransQue convertXmsToSms(OnlineXmsTransQue que) {
    	OnlineSmsTransQue onlineSmsTransQue = new OnlineSmsTransQue();
    	
    	onlineSmsTransQue.setMappingType(que.getMappingType());
    	onlineSmsTransQue.setIfId(que.getIfId());
    	onlineSmsTransQue.setSysCode(que.getSysCode());
    	onlineSmsTransQue.setTestYn(que.getTestYn());
    	onlineSmsTransQue.setCampId(que.getCampId());
    	onlineSmsTransQue.setMemberId(que.getMemberId());
    	onlineSmsTransQue.setMemberType(que.getMemberType());
    	onlineSmsTransQue.setForcedSendYn(que.getForcedSendYn());
    	onlineSmsTransQue.setMemberPhone(que.getMemberPhone());
    	onlineSmsTransQue.setFromNumber(que.getFromNumber());
    	onlineSmsTransQue.setField1(que.getField1());
    	onlineSmsTransQue.setField2(que.getField2());
    	onlineSmsTransQue.setField3(que.getField3());
    	onlineSmsTransQue.setField4(que.getField4());
    	onlineSmsTransQue.setField5(que.getField5());
    	onlineSmsTransQue.setField6(que.getField6());
    	onlineSmsTransQue.setField7(que.getField7());
    	onlineSmsTransQue.setField8(que.getField8());
    	onlineSmsTransQue.setField9(que.getField9());
    	onlineSmsTransQue.setField10(que.getField10());
    	onlineSmsTransQue.setShortUrl1(que.getShortUrl1());
    	onlineSmsTransQue.setShortUrl2(que.getShortUrl2());
    	onlineSmsTransQue.setShortUrl3(que.getShortUrl3());
    	onlineSmsTransQue.setShortUrl4(que.getShortUrl4());
    	onlineSmsTransQue.setShortUrl5(que.getShortUrl5());
    	onlineSmsTransQue.setLongUrl1(que.getLongUrl1());
    	onlineSmsTransQue.setLongUrl2(que.getLongUrl2());
    	onlineSmsTransQue.setLongUrl3(que.getLongUrl3());
    	onlineSmsTransQue.setLongUrl4(que.getLongUrl4());
    	onlineSmsTransQue.setLongUrl5(que.getLongUrl5());
    	onlineSmsTransQue.setServerId(null);
    	onlineSmsTransQue.setTargetFlag("N");
    	onlineSmsTransQue.setPollKey(null);
    	onlineSmsTransQue.setTemplateMsgId(que.getTemplateMsgId());
    	
    	onlineSmsTransQue.setUmsReserveDay(que.getUmsReserveDay());
    	
    	return onlineSmsTransQue;
    }
}
