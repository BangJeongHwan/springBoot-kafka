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
@Table(name="UMS_ONLINE_PUSH_QUEUE")
public class OnlinePushQue extends BaseOnlineChnQue implements Serializable {

    @Id
    @Column(name="PUSH_QUEUE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long queueId;
    
    public OnlineXmsTransQue convertPushToXms(OnlinePushQue que) {
    	OnlineXmsTransQue onlineXmsTransQue = new OnlineXmsTransQue();
    	
    	onlineXmsTransQue.setMappingType(que.getMappingType());
    	onlineXmsTransQue.setIfId(que.getIfId());
    	onlineXmsTransQue.setSysCode(que.getSysCode());
    	onlineXmsTransQue.setTestYn(que.getTestYn());
    	onlineXmsTransQue.setCampId(que.getCampId());
    	onlineXmsTransQue.setMemberId(que.getMemberId());
    	onlineXmsTransQue.setMemberType(que.getMemberType());
    	onlineXmsTransQue.setForcedSendYn(que.getForcedSendYn());
    	onlineXmsTransQue.setMemberPhone(que.getMemberPhone());
    	onlineXmsTransQue.setFromNumber(que.getFromNumber());
    	onlineXmsTransQue.setField1(que.getField1());
    	onlineXmsTransQue.setField2(que.getField2());
    	onlineXmsTransQue.setField3(que.getField3());
    	onlineXmsTransQue.setField4(que.getField4());
    	onlineXmsTransQue.setField5(que.getField5());
    	onlineXmsTransQue.setField6(que.getField6());
    	onlineXmsTransQue.setField7(que.getField7());
    	onlineXmsTransQue.setField8(que.getField8());
    	onlineXmsTransQue.setField9(que.getField9());
    	onlineXmsTransQue.setField10(que.getField10());
    	onlineXmsTransQue.setShortUrl1(que.getShortUrl1());
    	onlineXmsTransQue.setShortUrl2(que.getShortUrl2());
    	onlineXmsTransQue.setShortUrl3(que.getShortUrl3());
    	onlineXmsTransQue.setShortUrl4(que.getShortUrl4());
    	onlineXmsTransQue.setShortUrl5(que.getShortUrl5());
    	onlineXmsTransQue.setLongUrl1(que.getLongUrl1());
    	onlineXmsTransQue.setLongUrl2(que.getLongUrl2());
    	onlineXmsTransQue.setLongUrl3(que.getLongUrl3());
    	onlineXmsTransQue.setLongUrl4(que.getLongUrl4());
    	onlineXmsTransQue.setLongUrl5(que.getLongUrl5());
    	onlineXmsTransQue.setServerId(null);
    	onlineXmsTransQue.setTargetFlag("N");
    	onlineXmsTransQue.setPollKey(null);
    	onlineXmsTransQue.setTemplateMsgId(que.getTemplateMsgId());
    	
    	onlineXmsTransQue.setUmsReserveDay(que.getUmsReserveDay());
    	
    	return onlineXmsTransQue;
    }
}