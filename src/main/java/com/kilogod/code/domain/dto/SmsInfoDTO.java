package com.kilogod.code.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anding
 * @description
 */
@Data
@ApiModel
public class SmsInfoDTO {
    @ApiModelProperty("手机号")
    private String phone;
    @ApiModelProperty("类型：登录还是注册 login,register")
    private String type;
    @ApiModelProperty("验证码")
    private String code;
}
