package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.IntegralRecord;
import com.kilogod.code.domain.dto.IntegralRecordQueryDTO;
import com.kilogod.code.mapper.IntegralRecordMapper;
import com.kilogod.code.service.IIntegralRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 积分记录 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class IntegralRecordServiceImpl extends ServiceImpl<IntegralRecordMapper, IntegralRecord> implements IIntegralRecordService {

    @Resource
    private IntegralRecordMapper mapper;

    @Override
    public int insert(IntegralRecord integralRecord) throws ValidationException {
        int insert = mapper.insert(integralRecord);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<IntegralRecord>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(IntegralRecord integralRecord) throws ValidationException {
        int i = mapper.updateById(integralRecord);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<IntegralRecord> getList(IntegralRecordQueryDTO dto) throws ValidationException {
        List<IntegralRecord> lists = mapper.selectList(new QueryWrapper<IntegralRecord>()
                .eq(null!=dto.getUserId()&&0!=dto.getUserId(),"user_id",dto.getUserId())
                .like(StringUtils.isNotBlank(dto.getOrderId()),"order_id",dto.getOrderId()));
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
