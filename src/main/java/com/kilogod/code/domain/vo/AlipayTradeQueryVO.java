package com.kilogod.code.domain.vo;

import io.swagger.annotations.ApiModel;
import lombok.Data;

/**
 * @Author Anding
 * @Desc
 */
@Data
@ApiModel("支付宝支付结果查询")
public class AlipayTradeQueryVO {
    private String buyer_logon_id;
    private String buyer_pay_amount;
    private String buyer_user_id;
    private String buyer_user_type;
    private String invoice_amount;
    private String out_trade_no;
    private String point_amount;
    private String receipt_amount;
    private String send_pay_date;
    private String total_amount;
    private String trade_no;
    private String trade_status;
}
