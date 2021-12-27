package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author anding
 * @description
 */
@Data
public class UserQueryDTO extends BaseQuery {
    @ApiModelProperty("用户昵称")
    private String name;
    private String username;
    private String phone;
    private String email;
    private String role;
    private String inUse;
}
