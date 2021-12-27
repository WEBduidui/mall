package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.ShopCategory;
import com.kilogod.code.domain.dto.ShopCategoryQueryDTO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 商品分类 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IShopCategoryService extends IService<ShopCategory> {

    /**
    * 添加商品分类
    *
    * @param shopCategory 商品分类
    * @return int
    * @throws ValidationException
    */
    int insert(ShopCategory shopCategory) throws ValidationException;

    /**
    * 删除商品分类
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改商品分类
    *
    * @param shopCategory 商品分类
    * @return int
    * @throws ValidationException
    */
    int updateData(ShopCategory shopCategory) throws ValidationException;

    /**
     * 查询商品分类分页数据
     * @return List<ShopCategory>
     */
    List<ShopCategory> getList(ShopCategoryQueryDTO dto) throws ValidationException;

    /**
    * 批量删除商品分类
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
