package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.Collection;
import com.kilogod.code.domain.dto.CollectionQueryDTO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 收藏 服务类
 * </p>
 *
 * @author Anding
 */
public interface ICollectionService extends IService<Collection> {

    /**
    * 添加收藏
    *
    * @param collection 收藏
    * @return int
    * @throws ValidationException
    */
    int insert(Collection collection) throws ValidationException;

    /**
    * 删除收藏
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改收藏
    *
    * @param collection 收藏
    * @return int
    * @throws ValidationException
    */
    int updateData(Collection collection) throws ValidationException;

    /**
     * 查询收藏分页数据
     * @return List<Collection>
     */
    List<Collection> getList(CollectionQueryDTO dto) throws ValidationException;

    /**
    * 批量删除收藏
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
