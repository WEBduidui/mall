package com.kilogod.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kilogod.code.domain.AddressInfo;

/**
 * <p>
 * 客户地址信息 Mapper 接口
 * </p>
 *
 * @author Anding
 * @since
 */
public interface AddressInfoMapper extends BaseMapper<AddressInfo> {
    int updateAll(Integer userId);
}
