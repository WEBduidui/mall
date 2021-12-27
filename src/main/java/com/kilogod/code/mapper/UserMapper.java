package com.kilogod.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kilogod.code.domain.User;

import java.math.BigDecimal;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author Anding
 * @since
 */
public interface UserMapper extends BaseMapper<User> {
    int updateAmount(int userId, BigDecimal val);
}
