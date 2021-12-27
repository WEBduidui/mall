package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anding
 * @Description:
 */
@Data
public class OrderQueryDTO extends BaseQuery {
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "下单时间")
    private String createTime;

    @ApiModelProperty(value = "订单id")
    private String orderId;

    @ApiModelProperty(value = "订单状态")
    private String status;
}
