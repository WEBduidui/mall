package com.kilogod.code.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.domain.AddressInfo;
import com.kilogod.code.domain.Goods;
import com.kilogod.code.domain.OrderInfo;
import com.kilogod.code.domain.Shopcart;
import com.kilogod.code.domain.dto.ShopcartQueryDTO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.mapper.ShopcartMapper;
import com.kilogod.code.service.IAddressInfoService;
import com.kilogod.code.service.IGoodsService;
import com.kilogod.code.service.IOrderInfoService;
import com.kilogod.code.service.IShopcartService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 购物车 服务实现类
 * </p>
 *
 * @author Anding
 */
@Service
public class ShopcartServiceImpl extends ServiceImpl<ShopcartMapper, Shopcart> implements IShopcartService {

    @Resource
    private ShopcartMapper mapper;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private IAddressInfoService addressInfoService;
    @Resource
    private IOrderInfoService orderInfoService;

    @Override
    public int insert(Shopcart shopcart) throws ValidationException {
        Goods goods = goodsService.getOne(new QueryWrapper<Goods>().eq("id", shopcart.getShopId()));
        shopcart.setShopName(goods.getShopName());
        shopcart.setImageSrc(goods.getImageSrc());

        Shopcart one = this.getOne(new QueryWrapper<Shopcart>().eq("user_id", shopcart.getUserId()).eq("shop_id", shopcart.getShopId()));
        int insert;
        if (one!=null){
            shopcart.setNum(one.getNum()+1);
            shopcart.setPrice(goods.getPrice());
            shopcart.setTotal(goods.getPrice().multiply(new BigDecimal(shopcart.getNum())));
            insert = mapper.update(shopcart,new QueryWrapper<Shopcart>().eq("user_id", shopcart.getUserId()).eq("shop_id", shopcart.getShopId()));
            if (insert < 1) {
                throw new ValidationException(ResultCode.UPDATE_FAIL);
            }
        }else {
            shopcart.setNum(1);
            shopcart.setPrice(goods.getPrice());
            shopcart.setTotal(goods.getPrice().multiply(new BigDecimal(shopcart.getNum())));
            insert = mapper.insert(shopcart);
            if (insert < 1) {
                throw new ValidationException(ResultCode.INSERT_FAIL);
            }
        }

        return insert;
    }

    @Override
    public int delete(String id) throws ValidationException {
        int i = mapper.delete(new QueryWrapper<Shopcart>().eq("id", id));
        if (i<1){
            throw new ValidationException(ResultCode.DELETE_FAIL);
        }
        return i;
    }

    @Override
    public int updateData(Shopcart shopcart) throws ValidationException {
        Goods goods = goodsService.getOne(new QueryWrapper<Goods>().eq("id", shopcart.getShopId()));
        shopcart.setTotal(goods.getPrice().multiply(new BigDecimal(shopcart.getNum())));
        int i = mapper.updateById(shopcart);
        if (i<1){
            throw new ValidationException(ResultCode.UPDATE_FAIL);
        }
        return i;
    }

    @Override
    public List<Shopcart> getList(ShopcartQueryDTO dto) throws ValidationException {
        List<Shopcart> lists = mapper.selectList(new QueryWrapper<Shopcart>()
                    .eq(null!=dto.getUserId(),"user_id",dto.getUserId())
                    .eq(null!=dto.getShopId(),"shop_id",dto.getShopId())
                    .like(StringUtils.isNotBlank(dto.getShopName()),"shop_name",dto.getShopName())
                    .like(StringUtils.isNotBlank(dto.getImageSrc()),"image_src",dto.getImageSrc())
                    .eq(null!=dto.getPrice(),"price",dto.getPrice())
                    .eq(null!=dto.getNum(),"num",dto.getNum())
                    .eq(null!=dto.getTotal(),"total",dto.getTotal())
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

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public int settlement(List<Integer> ids, UserInfoVO vo) throws ValidationException {
        List<AddressInfo> lists = addressInfoService.list(new QueryWrapper<AddressInfo>().eq("user_id", vo.getId()));
        if (CollectionUtils.isEmpty(lists)){
            throw new ValidationException(ResultCode.RECEIVER_ADDRESS_IS_NULL);
        }
        AddressInfo addressInfo;
        long count = lists.stream().filter(l -> "1".equals(l.getIsDefault())).count();
        if (count==1){
            List<AddressInfo> collect = lists.stream().filter(l -> "1".equals(l.getIsDefault())).collect(Collectors.toList());
            addressInfo=collect.get(0);
        }else {
            addressInfo=lists.get(0);
        }

        for (Integer id : ids) {
            Shopcart shopcart = this.getOne(new QueryWrapper<Shopcart>().eq("id", id));
            Goods goods = goodsService.getOne(new QueryWrapper<Goods>().eq("id", shopcart.getShopId()));
            OrderInfo orderInfo=new OrderInfo();
            orderInfo.setUserId(vo.getId());
            orderInfo.setStatus("1");
            orderInfo.setReceiverId(addressInfo.getId());
            orderInfo.setPrice(shopcart.getTotal());
            orderInfo.setShopId(goods.getShopId());
            orderInfo.setExt1(String.valueOf(shopcart.getNum()));
            orderInfoService.insert(orderInfo);

            goods.setSales(goods.getSales()+shopcart.getNum());
            goodsService.updateData(goods);
            this.removeById(shopcart.getId());
        }
        return 0;
    }
}
