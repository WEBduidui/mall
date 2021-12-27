package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anding
 * @Description:
 */
@Data
public class ShopCategoryQueryDTO extends BaseQuery {
    @ApiModelProperty(value = "分类名称")
    private String categoryName;
}
