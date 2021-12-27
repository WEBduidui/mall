package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.Goods;
import com.kilogod.code.domain.dto.GoodsQueryDTO;
import com.kilogod.code.mapper.GoodsMapper;
import com.kilogod.code.service.IGoodsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author Anding
 * @since
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements IGoodsService {

    @Resource
    private GoodsMapper mapper;

    @Override
    public int insert(Goods goods) throws ValidationException {
        int insert = mapper.insert(goods);
        if (insert < 1) {
            throw new ValidationException(ResultCode.INSERT_FAIL);
        }
        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<Goods>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(Goods goods) throws ValidationException {
        int i = mapper.updateById(goods);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<Goods> getList(GoodsQueryDTO dto) throws ValidationException {
        List<Goods> lists;
        if (null!=dto.getIsHot()&&1==dto.getIsHot()){
            lists = mapper.selectList(new QueryWrapper<Goods>()
                    .eq(null!=dto.getId()&&dto.getId()!=0,"id",dto.getId())
                    .eq(StringUtils.isNotBlank(dto.getIsput()),"isput",dto.getIsput())
                    .like(StringUtils.isNotBlank(dto.getShopId()),"shop_id",dto.getShopId())
                    .like(StringUtils.isNotBlank(dto.getShopName()),"shop_name",dto.getShopName())
                    .eq(null!=dto.getCategoryId()&&dto.getCategoryId()!=0,"category_id",dto.getCategoryId())
            ).subList(0, 5);
        }else {
            lists = mapper.selectList(new QueryWrapper<Goods>()
                    .eq(null!=dto.getId()&&dto.getId()!=0,"id",dto.getId())
                    .eq(StringUtils.isNotBlank(dto.getIsput()),"isput",dto.getIsput())
                    .like(StringUtils.isNotBlank(dto.getShopId()),"shop_id",dto.getShopId())
                    .like(StringUtils.isNotBlank(dto.getShopName()),"shop_name",dto.getShopName())
                    .eq(null!=dto.getCategoryId()&&dto.getCategoryId()!=0,"category_id",dto.getCategoryId())
                    .orderByDesc(null!=dto.getIsSales()&&dto.getIsSales()==1,"sales")
                    .orderByDesc(null!=dto.getIsPrice()&&dto.getIsPrice()==1,"price")
                    .orderByAsc(null!=dto.getIsPrice()&&dto.getIsPrice()==2,"price")
                    .orderByDesc("create_time")
            );
            if (CollectionUtils.isEmpty(lists)){
                throw new ValidationException(ResultCode.QUERY_IS_NULL);
            }
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
