package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.SmsLog;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 短信日志记录表 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface ISmsLogService extends IService<SmsLog> {

    /**
    * 添加短信日志记录表
    *
    * @param smsLog 短信日志记录表
    * @return int
    * @throws ValidationException
    */
    int insert(SmsLog smsLog) throws ValidationException;

    /**
    * 删除短信日志记录表
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改短信日志记录表
    *
    * @param smsLog 短信日志记录表
    * @return int
    * @throws ValidationException
    */
    int updateData(SmsLog smsLog) throws ValidationException;

    /**
     * 查询短信日志记录表分页数据
     * @return List<SmsLog>
     */
    List<SmsLog> getList() throws ValidationException;

    /**
    * 批量删除短信日志记录表
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
