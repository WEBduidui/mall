package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import lombok.Data;

/**
 * @author anding
 * @Description:
 */
@Data
public class TradeSerialQueryDTO extends BaseQuery {
    private Integer userId;
    private String orderId;
    private String tradeNo;
}