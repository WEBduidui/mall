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
 * 支付退款表
 * </p>
 *
 * @author Anding
 * @since
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PayRefund对象", description="支付退款表")
public class PayRefund implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "退款金额")
    private BigDecimal refundAmount;

    @ApiModelProperty(value = "支付流水号")
    private String outTradeNo;

    @ApiModelProperty(value = "退款流水号")
    private String refundNo;

    @ApiModelProperty(value = "支付宝交易凭证号")
    private String tradeNo;

    @ApiModelProperty(value = "退款原因")
    private String refundReason;

    @ApiModelProperty(value = "用户的登录id")
    private String buyerLogonId;

    @ApiModelProperty(value = "买家在支付宝的用户id")
    private String buyerUserId;

    @ApiModelProperty(value = "退款是否发生了资金变化")
    private String fundChange;

    @ApiModelProperty(value = "退款总金额")
    private BigDecimal refundFee;

    @ApiModelProperty(value = "退款支付时间")
    private Date gmtRefundPay;

    @CreateTime
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建退款时间")
    private Date createTime;

    @ApiModelProperty(value = "扩展字段")
    private String ext1;

    @ApiModelProperty(value = "扩展字段")
    private String ext2;


}
