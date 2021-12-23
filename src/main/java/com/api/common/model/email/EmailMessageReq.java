package com.api.common.model.email;

import com.api.common.model.AbstractMessage;
import com.api.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.joda.time.DateTime;

import java.io.Serializable;

/**
 * @author jh.bang
 */
@Builder    // "빌더 패턴"으로 객체를 생성 (예시:Dto dto = DTO.builder().content("test").build();)
@Data       // @Getter + @Setter + @RequiredArgsConstructor + @ToString + @EqualsAndHashCode
@AllArgsConstructor(access = AccessLevel.PRIVATE)   // 모든 필드를 자동으로 생성 (private 에서만 접근 가능)
@NoArgsConstructor                                  // 기본생성자 생성
@JsonInclude(JsonInclude.Include.NON_NULL)          // json -> object로 변경시 null 생략
@JsonIgnoreProperties(ignoreUnknown = true)         // json 데이터 중 클래스에 명명되지 않는 필드에 대해 무시
public class EmailMessageReq extends AbstractMessage implements Serializable {

    // from email address
    private String fromEmail;

    // request date
    private String requestDate = DateTime.now().toString(DateUtils.DATE_TIME_FORMAT);

    // full content (html)
    private String content;

    // send type (MASS, AUTO)
    private String sendType;

    // member email address
    private String memberEmail;

    // member uuid
    private String sendKey;

    // expire time(ms)
    private String ttl;

    // campagin id( @if MASS, AUTO is not separated )
    private String campaginId;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
