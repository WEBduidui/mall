package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.Agreement;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 协议 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IAgreementService extends IService<Agreement> {

    /**
    * 添加协议
    *
    * @param agreement 协议
    * @return int
    * @throws ValidationException
    */
    int insert(Agreement agreement) throws ValidationException;

    /**
    * 删除协议
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改协议
    *
    * @param agreement 协议
    * @return int
    * @throws ValidationException
    */
    int updateData(Agreement agreement) throws ValidationException;

    /**
     * 查询协议分页数据
     * @return List<Agreement>
     */
    List<Agreement> getList() throws ValidationException;

    /**
    * 批量删除协议
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
