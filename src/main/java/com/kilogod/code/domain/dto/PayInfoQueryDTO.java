package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anding
 * @Description:
 */
@Data
public class PayInfoQueryDTO extends BaseQuery {

    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "支付宝交易凭证号")
    private String tradeNo;

    @ApiModelProperty(value = "支付流水号")
    private String outTradeNo;

    @ApiModelProperty(value = "支付状态 WAIT_BUYER_PAY:交易创建，等待买家付款 TRADE_CLOSED:未付款交易超时关闭，或支付完成后全额退款 TRADE_SUCCESS:	交易支付成功 TRADE_FINISHED:交易结束，不可退款")
    private String tradeStatus;

}
