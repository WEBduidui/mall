package com.kilogod.code.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kilogod.code.config.autofill.CreateTime;
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
 * 支付订单表
 * </p>
 *
 * @author Anding
 * @since
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="PayInfo对象", description="支付订单表")
public class PayInfo implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "支付金额")
    private BigDecimal totalAmount;

    @ApiModelProperty(value = "实收金额")
    private BigDecimal receiptAmount;

    @ApiModelProperty(value = "付款金额")
    private BigDecimal buyerPayAmount;

    @ApiModelProperty(value = "支付宝交易凭证号")
    private String tradeNo;

    @ApiModelProperty(value = "支付流水号")
    private String outTradeNo;

    @ApiModelProperty(value = "订单标题")
    private String subject;

    @ApiModelProperty(value = "订单描述")
    private String body;

    @ApiModelProperty(value = "支付状态 WAIT_BUYER_PAY:交易创建，等待买家付款 TRADE_CLOSED:未付款交易超时关闭，或支付完成后全额退款 TRADE_SUCCESS:	交易支付成功 TRADE_FINISHED:交易结束，不可退款")
    private String tradeStatus;

    @ApiModelProperty(value = "买家支付宝账号")
    private String buyerId;

    @ApiModelProperty(value = "卖家支付宝用户号")
    private String sellerId;

    @ApiModelProperty(value = "支付金额信息 ")
    private String fundBillList;

    @ApiModelProperty(value = "交易到账时间")
    private Date sendPayDate;

    @CreateTime
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "下单时间")
    private Date createTime;

    @ApiModelProperty(value = "扩展字段")
    private String ext1;

    @ApiModelProperty(value = "扩展字段")
    private String ext2;

    @ApiModelProperty(value = "扩展字段")
    private String ext3;

    @ApiModelProperty(value = "扩展字段")
    private String ext4;


}
