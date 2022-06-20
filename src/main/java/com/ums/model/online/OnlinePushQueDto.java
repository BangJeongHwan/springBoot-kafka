package com.ums.model.online;

import com.ums.model.PushQueDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.ToString;

@Data
@ToString(callSuper = true)
public class OnlinePushQueDto extends PushQueDto {

  @Schema(description = "예약시간(2시간 이전 데이터까지 발송 가능)", example = "20220105110000")
  private String reserveDate;

}
