package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.Evaluate;
import com.kilogod.code.domain.OrderInfo;
import com.kilogod.code.domain.dto.EvaluateQueryDTO;
import com.kilogod.code.mapper.EvaluateMapper;
import com.kilogod.code.service.IEvaluateService;
import com.kilogod.code.service.IOrderInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 评价 服务实现类
 * </p>
 *
 * @author Anding
 */
@Service
public class EvaluateServiceImpl extends ServiceImpl<EvaluateMapper, Evaluate> implements IEvaluateService {

    @Resource
    private EvaluateMapper mapper;
    @Autowired
    private IOrderInfoService orderInfoService;

    @Override
    public int insert(Evaluate evaluate) throws ValidationException {
        OrderInfo orderInfo = orderInfoService.getOne(new QueryWrapper<OrderInfo>().eq("order_id", evaluate.getOrderid()));
        orderInfo.setStatus("6");
        orderInfoService.updateData(orderInfo);
        int insert = mapper.insert(evaluate);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<Evaluate>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(Evaluate evaluate) throws ValidationException {
        int i = mapper.updateById(evaluate);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<Evaluate> getList(EvaluateQueryDTO dto) throws ValidationException {
        List<Evaluate> lists = mapper.selectList(new QueryWrapper<Evaluate>()
                    .eq(null!=dto.getUserid(),"userid",dto.getUserid())
                    .like(StringUtils.isNotBlank(dto.getOrderid()),"orderid",dto.getOrderid())
                    .like(StringUtils.isNotBlank(dto.getUsername()),"username",dto.getUsername())
                    .eq(null!=dto.getGoodsid(),"goodsid",dto.getGoodsid())
                    .like(StringUtils.isNotBlank(dto.getGoodsname()),"goodsname",dto.getGoodsname())
                    .like(StringUtils.isNotBlank(dto.getImg()),"img",dto.getImg())
                    .like(StringUtils.isNotBlank(dto.getScore()),"score",dto.getScore())
                    .like(StringUtils.isNotBlank(dto.getContent()),"content",dto.getContent())
        .orderByDesc("create_time"));
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
