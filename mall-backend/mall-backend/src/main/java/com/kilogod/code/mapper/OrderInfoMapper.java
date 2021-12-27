package com.kilogod.code.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kilogod.code.domain.OrderInfo;
import com.kilogod.code.domain.vo.AnalysisVO;
import com.kilogod.code.domain.vo.OrderanalysisVO;

import java.util.List;

/**
 * <p>
 * 订单 Mapper 接口
 * </p>
 *
 * @author Anding
 * @since
 */
public interface OrderInfoMapper extends BaseMapper<OrderInfo> {
    List<OrderanalysisVO> orderanalysis();
    List<AnalysisVO> typeanalysis();
}
