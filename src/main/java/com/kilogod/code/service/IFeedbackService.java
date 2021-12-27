package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.Feedback;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 意见反馈 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IFeedbackService extends IService<Feedback> {

    /**
    * 添加意见反馈
    *
    * @param feedback 意见反馈
    * @return int
    * @throws ValidationException
    */
    int insert(Feedback feedback) throws ValidationException;

    /**
    * 删除意见反馈
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改意见反馈
    *
    * @param feedback 意见反馈
    * @return int
    * @throws ValidationException
    */
    int updateData(Feedback feedback) throws ValidationException;

    /**
     * 查询意见反馈分页数据
     * @return List<Feedback>
     */
    List<Feedback> getList() throws ValidationException;

    /**
    * 批量删除意见反馈
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
