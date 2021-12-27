package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.TradeSerial;
import com.kilogod.code.domain.dto.TradeSerialQueryDTO;
import com.kilogod.code.mapper.TradeSerialMapper;
import com.kilogod.code.service.ITradeSerialService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 交易流水 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class TradeSerialServiceImpl extends ServiceImpl<TradeSerialMapper, TradeSerial> implements ITradeSerialService {

    @Resource
    private TradeSerialMapper mapper;

    @Override
    public int insert(TradeSerial tradeSerial) throws ValidationException {
        int insert = mapper.insert(tradeSerial);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<TradeSerial>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(TradeSerial tradeSerial) throws ValidationException {
        int i = mapper.updateById(tradeSerial);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<TradeSerial> getList(TradeSerialQueryDTO dto) throws ValidationException {
        List<TradeSerial> lists = mapper.selectList(new QueryWrapper<TradeSerial>()
                .eq("user_id",dto.getUserId())
                .like(StringUtils.isNotBlank(dto.getOrderId()),"order_id",dto.getOrderId())
                .like(StringUtils.isNotBlank(dto.getTradeNo()),"trade_no",dto.getTradeNo())
                .orderByDesc("create_time"));
        if (CollectionUtils.isEmpty(lists)){
            throw new ValidationException(ResultCode.QUERY_IS_NULL);
        }
        return lists;
    }

    @Override
    public List<TradeSerial> getListByAdmin(TradeSerialQueryDTO dto) throws ValidationException {
        List<TradeSerial> lists = mapper.selectList(new QueryWrapper<TradeSerial>()
                .eq(null!=dto.getUserId()&&0!=dto.getUserId(),"user_id",dto.getUserId())
                .like(StringUtils.isNotBlank(dto.getOrderId()),"order_id",dto.getOrderId())
                .like(StringUtils.isNotBlank(dto.getTradeNo()),"trade_no",dto.getTradeNo())
                .orderByDesc("create_time"));
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
