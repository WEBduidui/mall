package com.kilogod.code.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.kilogod.code.config.autofill.CreateTime;
import com.kilogod.code.config.autofill.UpdateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 系统配置表
 * </p>
 *
 * @author Anding
 * @since
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="SystemConfig对象", description="系统配置表")
public class SystemConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "主键id")
    private Integer id;

    @ApiModelProperty(value = "键")
    private String configKey;

    @ApiModelProperty(value = "值")
    private String configValue;

    @ApiModelProperty(value = "名称")
    private String configName;

    @ApiModelProperty(value = "类型")
    private String configType;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "排序号")
    @TableField("orderNo")
    private String orderNo;

    @ApiModelProperty(value = "是否启用")
    private String inUse;

    @CreateTime
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @UpdateTime
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "扩展字段")
    private String ext1;

    @ApiModelProperty(value = "扩展字段")
    private String ext2;


}
