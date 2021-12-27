package com.kilogod.code.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kilogod.code.config.autofill.CreateTime;
import com.kilogod.code.config.autofill.UpdateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author Anding
 * @since
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键用户id")
    private Integer id;

    @ApiModelProperty(value = "用户名称")
    private String username;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "手机号码")
    private String phone;

    @ApiModelProperty(value = "性别")
    private String sex;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "生日")
    private Date birthday;

    @ApiModelProperty(value = "是否会员")
    private String isVip;

    @ApiModelProperty(value = "是否代理")
    private String isAgent;

    @ApiModelProperty(value = "是否启用")
    private String inUse;

    @ApiModelProperty(value = "权限id")
    private Integer roleId;

    @ApiModelProperty(value = "储值金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "积分")
    private Integer integral;

    @CreateTime
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @UpdateTime
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "扩展字段")
    private String ext1;

    @ApiModelProperty(value = "扩展字段")
    private String ext2;

    @ApiModelProperty(value = "扩展字段")
    private String ext3;

    @ApiModelProperty(value = "扩展字段")
    private String ext4;


}
