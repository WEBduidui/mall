package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.ShopImage;
import com.kilogod.code.mapper.ShopImageMapper;
import com.kilogod.code.service.IShopImageService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 商品图片 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class ShopImageServiceImpl extends ServiceImpl<ShopImageMapper, ShopImage> implements IShopImageService {

    @Resource
    private ShopImageMapper mapper;

    @Override
    public int insert(ShopImage shopImage) throws ValidationException {
        int insert = mapper.insert(shopImage);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<ShopImage>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(ShopImage shopImage) throws ValidationException {
        int i = mapper.updateById(shopImage);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<ShopImage> getList() throws ValidationException {
        List<ShopImage> lists = mapper.selectList(new QueryWrapper<ShopImage>());
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
