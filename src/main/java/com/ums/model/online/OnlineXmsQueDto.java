package com.ums.model.online;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ums.model.XmsQueDto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Getter @Setter
@ToString(callSuper = true)
public class OnlineXmsQueDto extends XmsQueDto {
    @JsonProperty("RESERVE_DATE")
	private String reserveDate;
    private String distValue;

    @Override
    public String toString(){
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
