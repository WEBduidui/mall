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
 * 交易流水
 * </p>
 *
 * @author Anding
 * @since
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="TradeSerial对象", description="交易流水")
public class TradeSerial implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "充值消费金额")
    private BigDecimal amount;

    @ApiModelProperty(value = "订单号 （支付宝充值时为空）")
    private String orderId;

    @ApiModelProperty(value = "支付宝交易凭证号  （消费订单时为空）")
    private String tradeNo;

    @CreateTime
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "充值消费时间")
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
