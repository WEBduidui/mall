package com.kilogod.code.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author anding
 * @Description:
 */
@Data
public class PayInfoDTO  {
    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "支付金额")
    private BigDecimal totalAmount;

}
