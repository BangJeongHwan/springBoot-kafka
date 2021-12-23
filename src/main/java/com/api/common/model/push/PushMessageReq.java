package com.api.common.model.push;

import com.api.common.model.AbstractMessage;
import com.api.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author jh.bang
 */
@Builder
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PushMessageReq extends AbstractMessage implements Serializable {

    // app key
    private String appKey;

    // push chn type (APNS, GCM)
    private String pushChnType;

    // request date
    private String requestDate = DateTime.now().toString(DateUtils.DATE_TIME_FORMAT);

    // popup title
    private String title;

    // popup body
    private String body;

    // in app message
    private String inappMsg;

    // push type (T:Text, H:Html)
    private String pushType;

    // image
    private String image;

    // link (url patten)
    private String link;

    // sound ("default")
    private String sound;

    // badge (0, 1) - only use IOS
    private Integer badge;

    // only animation-push delay time(ms)
    private String animationDelay;

    // rich push type ( S:slide, A:animation)
    private String category;

    // rich push data ( JSONString )
    private String customParam;

    // style (T:Text, I:image, F:All Image, Y:youtobe, C:comment)  - only use GCM
    private String style;

    // reduction Image - only use GCM
    private String thumbnail;

    // using color YN (Y:use color, N:no use color) - only use GCM
    private String colorize;

    // member token
    private String token;

    // expire time(ms)
    private String ttl;

    // member uuid
    private String sendKey;

    // campagin id( @if MASS, AUTO is not separated )
    private String campaginId;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
