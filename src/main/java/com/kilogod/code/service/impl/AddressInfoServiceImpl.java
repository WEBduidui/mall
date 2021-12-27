package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.AddressInfo;
import com.kilogod.code.domain.dto.AddressInfoQueryDTO;
import com.kilogod.code.mapper.AddressInfoMapper;
import com.kilogod.code.service.IAddressInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 客户地址信息 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class AddressInfoServiceImpl extends ServiceImpl<AddressInfoMapper, AddressInfo> implements IAddressInfoService {

    @Resource
    private AddressInfoMapper mapper;


    @Override
    public List<AddressInfo> getAddressInfo(String userId) throws ValidationException {
        List<AddressInfo> exAddressInfos = mapper.selectList(new QueryWrapper<AddressInfo>().eq("user_id", userId));
        if (CollectionUtils.isEmpty(exAddressInfos)){
            throw new ValidationException(ResultCode.RECEIVER_ADDRESS_IS_FAIL);
        }
        return exAddressInfos;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int insert(AddressInfo addressInfo) throws ValidationException {
        if ("1".equals(addressInfo.getIsDefault())){
            mapper.updateAll(addressInfo.getUserId());
        }
        int insert = mapper.insert(addressInfo);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<AddressInfo>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(AddressInfo addressInfo) throws ValidationException {
        if ("1".equals(addressInfo.getIsDefault())){
            mapper.updateAll(addressInfo.getUserId());
        }
        int i = mapper.updateById(addressInfo);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<AddressInfo> getList(AddressInfoQueryDTO dto) throws ValidationException {
        List<AddressInfo> lists = mapper.selectList(new QueryWrapper<AddressInfo>()
                .eq(dto.getUserId()!=null&&dto.getUserId()!=0,"user_id",dto.getUserId())
                .like(StringUtils.isNotBlank(dto.getName()),"name",dto.getName())
                .like(StringUtils.isNotBlank(dto.getPhone()),"phone",dto.getPhone()));
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
