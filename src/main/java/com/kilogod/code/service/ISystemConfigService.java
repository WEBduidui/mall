package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.SystemConfig;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 系统配置表 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface ISystemConfigService extends IService<SystemConfig> {

    /**
    * 添加系统配置表
    *
    * @param systemConfig 系统配置表
    * @return int
    * @throws ValidationException
    */
    int insert(SystemConfig systemConfig) throws ValidationException;

    /**
    * 删除系统配置表
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改系统配置表
    *
    * @param systemConfig 系统配置表
    * @return int
    * @throws ValidationException
    */
    int updateData(SystemConfig systemConfig) throws ValidationException;

    /**
     * 查询系统配置表分页数据
     * @return List<SystemConfig>
     */
    List<SystemConfig> getList() throws ValidationException;

    /**
    * 批量删除系统配置表
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
