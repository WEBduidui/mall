package com.kilogod.code.domain.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Anding
 * @Desc
 */
@Data
@ApiModel
public class UserDTO {

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty("密码")
    private String password;


}
