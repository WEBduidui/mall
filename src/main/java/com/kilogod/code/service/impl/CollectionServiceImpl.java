package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.Collection;
import com.kilogod.code.domain.Goods;
import com.kilogod.code.domain.dto.CollectionQueryDTO;
import com.kilogod.code.mapper.CollectionMapper;
import com.kilogod.code.service.ICollectionService;
import com.kilogod.code.service.IGoodsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 收藏 服务实现类
 * </p>
 *
 * @author Anding
 */
@Service
public class CollectionServiceImpl extends ServiceImpl<CollectionMapper, Collection> implements ICollectionService {

    @Resource
    private CollectionMapper mapper;
    @Resource
    private IGoodsService goodsService;

    @Override
    public int insert(Collection collection) throws ValidationException {
        Collection one = this.getOne(new QueryWrapper<Collection>().eq("user_id", collection.getUserId()).eq("shop_id", collection.getShopId()));
        if (one!=null){
            throw new ValidationException(ResultCode.ALREADY_COLLECTION);
        }

        Goods goods = goodsService.getOne(new QueryWrapper<Goods>().eq("id", collection.getShopId()));
        collection.setShopName(goods.getShopName());
        collection.setImageSrc(goods.getImageSrc());
        collection.setPrice(goods.getPrice());
        int insert = mapper.insert(collection);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<Collection>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(Collection collection) throws ValidationException {
        int i = mapper.updateById(collection);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<Collection> getList(CollectionQueryDTO dto) throws ValidationException {
        List<Collection> lists = mapper.selectList(new QueryWrapper<Collection>()
                    .eq(null!=dto.getUserId(),"user_id",dto.getUserId())
                    .eq(null!=dto.getShopId(),"shop_id",dto.getShopId())
                    .like(StringUtils.isNotBlank(dto.getShopName()),"shop_name",dto.getShopName())
                    .like(StringUtils.isNotBlank(dto.getImageSrc()),"image_src",dto.getImageSrc())
                    .eq(null!=dto.getPrice(),"price",dto.getPrice())
        );
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
