package com.kilogod.code.domain.vo;

import lombok.Data;

/**
 * @Author Anding
 * @Desc
 */
@Data
public class AlipayTradeRefundVO {
    private String buyer_logon_id;
    private String buyer_user_id;
    private String fund_change;
    private String gmt_refund_pay;
    private String out_trade_no;
    private String refund_fee;
    private String send_back_fee;
    private String trade_no;
}
