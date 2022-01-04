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
@Table(name="UMS_ONLINE_PU_TRANS_QUEUE")
public class OnlinePushTransQue extends BaseOnlineChnQue implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long transQueueId;

    @Column(name="ONL_PU_ID")
    private long queueId;

    private String pushMsgTpc;
    private String sappLgnMngtNo;
    private String rplcFwUseYn;
    private String smsRdnyYn;
    private String rplcFwRcvrMpno;
    private String rplcFwDsptrTno;
    private String pushRplcFwCn;
    private String stdIfId;
//    private String sendFlag;

    public OnlinePushTransQue() {
    }

   /* public OnlinePushTransQue(BaseOnlineChnQue baseOnlineChnQue) {
        super(baseOnlineChnQue);
    }*/
}