package com.kilogod.code.domain.vo;

import com.kilogod.code.domain.Goods;
import com.kilogod.code.domain.OrderInfo;
import lombok.Data;

/**
 * @author anding
 * @version 1.0
 * @desciption:
 * @since JDK 1.8
 */
@Data
public class OrderInfoVO extends OrderInfo {
    private Goods goods;
}
