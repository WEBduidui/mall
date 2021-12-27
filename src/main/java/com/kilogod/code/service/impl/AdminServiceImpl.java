package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.Admin;
import com.kilogod.code.mapper.AdminMapper;
import com.kilogod.code.service.IAdminService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 管理员 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Resource
    private AdminMapper mapper;

    @Override
    public int insert(Admin admin) throws ValidationException {
        int insert = mapper.insert(admin);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<Admin>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(Admin admin) throws ValidationException {
        int i = mapper.updateById(admin);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<Admin> getList() throws ValidationException {
        List<Admin> lists = mapper.selectList(new QueryWrapper<Admin>());
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
