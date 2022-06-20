package com.ums.model.online;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ums.model.XmsQueDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter @Setter
@ToString(callSuper = true)
public class OnlineXmsQueDto extends XmsQueDto {

    @Schema(description = "예약시간(2시간 이전 데이터까지 발송 가능)", example = "20220105110000")
    @JsonProperty("RESERVE_DATE")
	private String reserveDate;
    @Schema(hidden = true)
    private String distValue;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
