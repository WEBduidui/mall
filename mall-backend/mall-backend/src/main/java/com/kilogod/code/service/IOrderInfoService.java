package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.OrderInfo;
import com.kilogod.code.domain.dto.OrderQueryDTO;
import com.kilogod.code.domain.vo.OrderInfoVO;
import com.kilogod.code.domain.vo.OrderanalysisVO;
import com.kilogod.code.domain.vo.TypeanalysisVO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 订单 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IOrderInfoService extends IService<OrderInfo> {

    /**
    * 添加订单
    *
    * @param order 订单
    * @return int
    * @throws ValidationException
    */
    int insert(OrderInfo order) throws ValidationException;

    /**
    * 删除订单
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改订单
    *
    * @param order 订单
    * @return int
    * @throws ValidationException
    */
    int updateData(OrderInfo order) throws ValidationException;

    /**
     * 查询订单分页数据
     * @return List<OrderInfo>
     */
    List<OrderInfo> getList(OrderQueryDTO dto) throws ValidationException;

    List<OrderInfoVO> listAndGoods(OrderQueryDTO dto) throws ValidationException;
    /**
    * 批量删除订单
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

    List<OrderanalysisVO> orderanalysis() throws ValidationException;

    TypeanalysisVO typeanalysis() throws ValidationException;
}
