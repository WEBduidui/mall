package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.Banner;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 首图 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IBannerService extends IService<Banner> {

    /**
    * 添加首图
    *
    * @param banner 首图
    * @return int
    * @throws ValidationException
    */
    int insert(Banner banner) throws ValidationException;

    /**
    * 删除首图
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改首图
    *
    * @param banner 首图
    * @return int
    * @throws ValidationException
    */
    int updateData(Banner banner) throws ValidationException;

    /**
     * 查询首图分页数据
     * @return List<Banner>
     */
    List<Banner> getList() throws ValidationException;

    /**
    * 批量删除首图
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
