package com.kilogod.code.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kilogod.code.config.autofill.CreateTime;
import com.kilogod.code.config.autofill.UpdateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 评价
 * </p>
 *
 * @author Anding
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Evaluate对象", description="评价")
public class Evaluate implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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

    @ApiModelProperty(value = "商品图片")
    @CreateTime
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @UpdateTime
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    @ApiModelProperty(value = "扩展字段")
    private String ext1;

    @ApiModelProperty(value = "扩展字段")
    private String ext2;

    @ApiModelProperty(value = "扩展字段")
    private String ext3;

    @ApiModelProperty(value = "扩展字段")
    private String ext4;


}
