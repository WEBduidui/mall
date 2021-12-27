package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.IntegralRecord;
import com.kilogod.code.domain.dto.IntegralRecordQueryDTO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 积分记录 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IIntegralRecordService extends IService<IntegralRecord> {

    /**
    * 添加积分记录
    *
    * @param integralRecord 积分记录
    * @return int
    * @throws ValidationException
    */
    int insert(IntegralRecord integralRecord) throws ValidationException;

    /**
    * 删除积分记录
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改积分记录
    *
    * @param integralRecord 积分记录
    * @return int
    * @throws ValidationException
    */
    int updateData(IntegralRecord integralRecord) throws ValidationException;

    /**
     * 查询积分记录分页数据
     * @return List<IntegralRecord>
     */
    List<IntegralRecord> getList(IntegralRecordQueryDTO dto) throws ValidationException;

    /**
    * 批量删除积分记录
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
