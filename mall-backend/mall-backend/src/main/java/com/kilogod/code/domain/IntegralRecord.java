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
 * 积分记录
 * </p>
 *
 * @author Anding
 * @since
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="IntegralRecord对象", description="积分记录")
public class IntegralRecord implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "订单号 （支付宝充值时为空）")
    private String orderId;

    @ApiModelProperty(value = "消费金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "积分个数")
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


}
