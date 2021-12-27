package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.PayRefund;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 支付退款表 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IPayRefundService extends IService<PayRefund> {

    /**
    * 添加支付退款表
    *
    * @param payRefund 支付退款表
    * @return int
    * @throws ValidationException
    */
    int insert(PayRefund payRefund) throws ValidationException;

    /**
    * 删除支付退款表
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改支付退款表
    *
    * @param payRefund 支付退款表
    * @return int
    * @throws ValidationException
    */
    int updateData(PayRefund payRefund) throws ValidationException;

    /**
     * 查询支付退款表分页数据
     * @return List<PayRefund>
     */
    List<PayRefund> getList() throws ValidationException;

    /**
    * 批量删除支付退款表
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
