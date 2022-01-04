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
@Table(name="UMS_ONLINE_SMS_TRANS_QUEUE")
public class OnlineSmsTransQue extends BaseOnlineChnQue implements Serializable {

    @Id
    @Column(name="SMS_QUEUE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long queueId;
}