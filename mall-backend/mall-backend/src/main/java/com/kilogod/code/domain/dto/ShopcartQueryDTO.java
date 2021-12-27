package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author Anding
 */
@Data
@ApiModel(value="ShopcartQueryDTO查询对象", description="购物车查询入参")
public class ShopcartQueryDTO extends BaseQuery {

    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "用户id")
    private Integer userId;

    @ApiModelProperty(value = "商品id")
    private Integer shopId;

    @ApiModelProperty(value = "商品名称")
    private String shopName;

    @ApiModelProperty(value = "商品图片")
    private String imageSrc;

    @ApiModelProperty(value = "单价")
    private BigDecimal price;

    @ApiModelProperty(value = "数量")
    private Integer num;

    @ApiModelProperty(value = "总价")
    private BigDecimal total;






}
