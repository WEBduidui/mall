package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.Agreement;
import com.kilogod.code.mapper.AgreementMapper;
import com.kilogod.code.service.IAgreementService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 协议 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class AgreementServiceImpl extends ServiceImpl<AgreementMapper, Agreement> implements IAgreementService {

    @Resource
    private AgreementMapper mapper;

    @Override
    public int insert(Agreement agreement) throws ValidationException {
        int insert = mapper.insert(agreement);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<Agreement>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(Agreement agreement) throws ValidationException {
        int i = mapper.updateById(agreement);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<Agreement> getList() throws ValidationException {
        List<Agreement> lists = mapper.selectList(new QueryWrapper<Agreement>());
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
