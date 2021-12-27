package com.kilogod.code.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anding
 * @Description:
 */
@Data
public class UserResetPwdDTO {
    @ApiModelProperty("用户手机")
    private String phone;
    @ApiModelProperty("验证码")
    private String code;
    @ApiModelProperty("新密码")
    private String newpwd;
}
