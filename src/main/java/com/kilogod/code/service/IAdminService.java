package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.Admin;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 管理员 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IAdminService extends IService<Admin> {

    /**
    * 添加管理员
    *
    * @param admin 管理员
    * @return int
    * @throws ValidationException
    */
    int insert(Admin admin) throws ValidationException;

    /**
    * 删除管理员
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改管理员
    *
    * @param admin 管理员
    * @return int
    * @throws ValidationException
    */
    int updateData(Admin admin) throws ValidationException;

    /**
     * 查询管理员分页数据
     * @return List<Admin>
     */
    List<Admin> getList() throws ValidationException;

    /**
    * 批量删除管理员
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
