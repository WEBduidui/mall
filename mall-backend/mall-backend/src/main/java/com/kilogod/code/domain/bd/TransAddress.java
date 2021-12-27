package com.kilogod.code.domain.bd;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anding
 * @Description:
 */
@ApiModel("百度解析地址")
@Data
public class TransAddress {
    @ApiModelProperty("请求唯一标识码")
    private String log_id;
    @ApiModelProperty("原始输入的文本内容")
    private String text;
    @ApiModelProperty("省（直辖市/自治区）")
    private String province;
    @ApiModelProperty("省国标code")
    private String province_code;
    @ApiModelProperty("市")
    private String city;
    @ApiModelProperty("城市国标code")
    private String city_code;
    @ApiModelProperty("区（县）")
    private String county;
    @ApiModelProperty("区县国标code")
    private String county_code;
    @ApiModelProperty("街道（乡/镇）")
    private String town;
    @ApiModelProperty("街道/乡镇国标code")
    private String town_code;
    @ApiModelProperty("姓名，如果出现多个则按顺序输出")
    private String person;
    @ApiModelProperty("详细地址")
    private String detail;
    @ApiModelProperty("电话号码，如果出现多个则按顺序输出")
    private String phonenum;

}
