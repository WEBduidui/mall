package com.kilogod.code.domain.vo;

import lombok.Data;

/**
 * @Author Anding
 * @Desc
 */
@Data
public class AlipayRefundQueryVO {
    private String out_request_no;
    private String out_trade_no;
    private String refund_amount;
    private String total_amount;
    private String trade_no;
}
