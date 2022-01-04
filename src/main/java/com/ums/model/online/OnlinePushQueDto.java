package com.ums.model.online;

import com.ums.model.PushQueDto;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class OnlinePushQueDto extends PushQueDto {

  private String reserveDate;

}
