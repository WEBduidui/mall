package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.Goods;
import com.kilogod.code.domain.dto.GoodsQueryDTO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 商品 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IGoodsService extends IService<Goods> {

    /**
    * 添加商品
    *
    * @param goods 商品
    * @return int
    * @throws ValidationException
    */
    int insert(Goods goods) throws ValidationException;

    /**
    * 删除商品
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改商品
    *
    * @param goods 商品
    * @return int
    * @throws ValidationException
    */
    int updateData(Goods goods) throws ValidationException;

    /**
     * 查询商品分页数据
     * @return List<Goods>
     */
    List<Goods> getList(GoodsQueryDTO dto) throws ValidationException;

    /**
    * 批量删除商品
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
