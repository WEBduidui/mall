package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.ShopCategory;
import com.kilogod.code.domain.dto.ShopCategoryQueryDTO;
import com.kilogod.code.mapper.ShopCategoryMapper;
import com.kilogod.code.service.IShopCategoryService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 商品分类 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class ShopCategoryServiceImpl extends ServiceImpl<ShopCategoryMapper, ShopCategory> implements IShopCategoryService {

    @Resource
    private ShopCategoryMapper mapper;

    @Override
    public int insert(ShopCategory shopCategory) throws ValidationException {
        int insert = mapper.insert(shopCategory);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<ShopCategory>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(ShopCategory shopCategory) throws ValidationException {
        int i = mapper.updateById(shopCategory);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<ShopCategory> getList(ShopCategoryQueryDTO dto) throws ValidationException {
        List<ShopCategory> lists = mapper.selectList(new QueryWrapper<ShopCategory>()
            .like(StringUtils.isNotBlank(dto.getCategoryName()),"category_name",dto.getCategoryName()));
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
