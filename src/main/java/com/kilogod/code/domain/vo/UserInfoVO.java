package com.kilogod.code.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author Anding
 * @Desc
 */
@Data
public class UserInfoVO {
    @ApiModelProperty(value = "用户id")
    private Integer id;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "性别")
    private String sex;

    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "储值金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "权限")
    private String role;
}
