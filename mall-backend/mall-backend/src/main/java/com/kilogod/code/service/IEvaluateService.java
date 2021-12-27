package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.Evaluate;
import com.kilogod.code.domain.dto.EvaluateQueryDTO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 评价 服务类
 * </p>
 *
 * @author Anding
 */
public interface IEvaluateService extends IService<Evaluate> {

    /**
    * 添加评价
    *
    * @param evaluate 评价
    * @return int
    * @throws ValidationException
    */
    int insert(Evaluate evaluate) throws ValidationException;

    /**
    * 删除评价
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改评价
    *
    * @param evaluate 评价
    * @return int
    * @throws ValidationException
    */
    int updateData(Evaluate evaluate) throws ValidationException;

    /**
     * 查询评价分页数据
     * @return List<Evaluate>
     */
    List<Evaluate> getList(EvaluateQueryDTO dto) throws ValidationException;

    /**
    * 批量删除评价
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
