package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.SmsLog;
import com.kilogod.code.mapper.SmsLogMapper;
import com.kilogod.code.service.ISmsLogService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 短信日志记录表 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class SmsLogServiceImpl extends ServiceImpl<SmsLogMapper, SmsLog> implements ISmsLogService {

    @Resource
    private SmsLogMapper mapper;

    @Override
    public int insert(SmsLog smsLog) throws ValidationException {
        int insert = mapper.insert(smsLog);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<SmsLog>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(SmsLog smsLog) throws ValidationException {
        int i = mapper.updateById(smsLog);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<SmsLog> getList() throws ValidationException {
        List<SmsLog> lists = mapper.selectList(new QueryWrapper<SmsLog>());
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
