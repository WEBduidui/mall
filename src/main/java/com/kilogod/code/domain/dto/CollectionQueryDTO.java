package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * <p>
 * 收藏
 * </p>
 *
 * @author Anding
 */
@Data
@ApiModel(value="CollectionQueryDTO查询对象", description="收藏查询入参")
public class CollectionQueryDTO extends BaseQuery {

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






}
