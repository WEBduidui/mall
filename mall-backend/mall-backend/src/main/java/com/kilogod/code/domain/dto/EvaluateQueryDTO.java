package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 评价
 * </p>
 *
 * @author Anding
 */
@Data
@ApiModel(value="EvaluateQueryDTO查询对象", description="评价查询入参")
public class EvaluateQueryDTO extends BaseQuery {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id")
    private String orderid;

    @ApiModelProperty(value = "用户id")
    private Integer userid;

    @ApiModelProperty(value = "用户姓名")
    private String username;

    @ApiModelProperty(value = "商品id")
    private Integer goodsid;

    @ApiModelProperty(value = "商品名称")
    private String goodsname;

    @ApiModelProperty(value = "商品图片")
    private String img;

    @ApiModelProperty(value = "评分")
    private String score;

    @ApiModelProperty(value = "评价内容")
    private String content;








}
