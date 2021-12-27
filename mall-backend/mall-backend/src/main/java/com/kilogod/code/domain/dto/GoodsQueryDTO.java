package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anding
 * @Description:
 */
@Data
public class GoodsQueryDTO extends BaseQuery {
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "商品编码")
    private String shopId;

    @ApiModelProperty(value = "商品名称")
    private String shopName;

    @ApiModelProperty(value = "分类id")
    private Integer categoryId;

    @ApiModelProperty(value = "是否上架")
    private String isput;

    @ApiModelProperty(value = "按销量排序")
    private Integer isSales;

    @ApiModelProperty(value = "按价格排序")
    private Integer isPrice;

    @ApiModelProperty(value = "热销商品")
    private Integer isHot;
}
