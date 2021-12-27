package com.kilogod.code.domain.dto;

import com.kilogod.code.common.query.BaseQuery;
import lombok.Data;

/**
 * @author anding
 * @Description:
 */
@Data
public class AddressInfoQueryDTO extends BaseQuery {
    private Integer userId;
    private String name;
    private String phone;
}
