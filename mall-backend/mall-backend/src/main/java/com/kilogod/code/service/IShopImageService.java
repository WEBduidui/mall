package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.ShopImage;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 商品图片 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IShopImageService extends IService<ShopImage> {

    /**
    * 添加商品图片
    *
    * @param shopImage 商品图片
    * @return int
    * @throws ValidationException
    */
    int insert(ShopImage shopImage) throws ValidationException;

    /**
    * 删除商品图片
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改商品图片
    *
    * @param shopImage 商品图片
    * @return int
    * @throws ValidationException
    */
    int updateData(ShopImage shopImage) throws ValidationException;

    /**
     * 查询商品图片分页数据
     * @return List<ShopImage>
     */
    List<ShopImage> getList() throws ValidationException;

    /**
    * 批量删除商品图片
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
