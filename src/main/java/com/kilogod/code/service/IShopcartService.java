package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.Shopcart;
import com.kilogod.code.domain.dto.ShopcartQueryDTO;
import com.kilogod.code.domain.vo.UserInfoVO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 购物车 服务类
 * </p>
 *
 * @author Anding
 */
public interface IShopcartService extends IService<Shopcart> {

    /**
    * 添加购物车
    *
    * @param shopcart 购物车
    * @return int
    * @throws ValidationException
    */
    int insert(Shopcart shopcart) throws ValidationException;

    /**
    * 删除购物车
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改购物车
    *
    * @param shopcart 购物车
    * @return int
    * @throws ValidationException
    */
    int updateData(Shopcart shopcart) throws ValidationException;

    /**
     * 查询购物车分页数据
     * @return List<Shopcart>
     */
    List<Shopcart> getList(ShopcartQueryDTO dto) throws ValidationException;

    /**
    * 批量删除购物车
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

    /**
     * @Author anding
     * @Param [ids]
     * @return int
     * @Description 计算购物车
     **/
    int settlement(List<Integer> ids, UserInfoVO vo) throws ValidationException;
}
