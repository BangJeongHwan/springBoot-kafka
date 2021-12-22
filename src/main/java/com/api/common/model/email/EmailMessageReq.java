package com.api.common.model.email;

import com.api.common.model.AbstractMessage;
import com.api.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.joda.time.DateTime;

import java.io.Serializable;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmailMessageReq extends AbstractMessage implements Serializable {

    @JsonProperty("from_email")
    private String fromEmail;

    @JsonProperty("request_date")
    private String requestDate = DateTime.now().toString(DateUtils.DATE_TIME_FORMAT);

    @JsonProperty("content")
    private String content;

    @JsonProperty("send_type")
    private String sendType;

    @JsonProperty("member_email")
    private String memberEmail;

    @JsonProperty("send_key")
    private String sendKey;
}
