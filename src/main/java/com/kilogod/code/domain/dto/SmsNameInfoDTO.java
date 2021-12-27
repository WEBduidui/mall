package com.kilogod.code.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anding
 * @Description:
 */
@Data
@ApiModel
public class SmsNameInfoDTO {
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("短信模版CODE")
    private String templateCode;
    @ApiModelProperty("短信模版参数")
    private String templateParam;
}