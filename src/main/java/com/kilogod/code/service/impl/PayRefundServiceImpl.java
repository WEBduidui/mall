package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.PayRefund;
import com.kilogod.code.mapper.PayRefundMapper;
import com.kilogod.code.service.IPayRefundService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 支付退款表 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class PayRefundServiceImpl extends ServiceImpl<PayRefundMapper, PayRefund> implements IPayRefundService {

    @Resource
    private PayRefundMapper mapper;

    @Override
    public int insert(PayRefund payRefund) throws ValidationException {
        int insert = mapper.insert(payRefund);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<PayRefund>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(PayRefund payRefund) throws ValidationException {
        int i = mapper.updateById(payRefund);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<PayRefund> getList() throws ValidationException {
        List<PayRefund> lists = mapper.selectList(new QueryWrapper<PayRefund>());
        if (CollectionUtils.isEmpty(lists)){
            throw new ValidationException(ResultCode.QUERY_IS_NULL);
        }
        return lists;
    }

    @Override
    public int batchDelete(List<Integer> ids) throws ValidationException {
        int i = mapper.deleteBatchIds(ids);
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }
}
