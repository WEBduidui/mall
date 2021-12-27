package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anding
 * @Description:
 */
@Data
public class IntegralRecordQueryDTO extends BaseQuery {
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "订单号 （支付宝充值时为空）")
    private String orderId;
}
