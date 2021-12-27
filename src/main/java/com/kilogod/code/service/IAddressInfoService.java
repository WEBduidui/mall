package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.AddressInfo;
import com.kilogod.code.domain.dto.AddressInfoQueryDTO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 客户地址信息 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IAddressInfoService extends IService<AddressInfo> {

    /**
     * 根据用户id查询地址信息
     * @param userId
     * @return
     */
    List<AddressInfo> getAddressInfo(String userId) throws ValidationException;

    /**
    * 添加客户地址信息
    *
    * @param addressInfo 客户地址信息
    * @return int
    * @throws ValidationException
    */
    int insert(AddressInfo addressInfo) throws ValidationException;

    /**
    * 删除客户地址信息
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改客户地址信息
    *
    * @param addressInfo 客户地址信息
    * @return int
    * @throws ValidationException
    */
    int updateData(AddressInfo addressInfo) throws ValidationException;

    /**
     * 查询客户地址信息分页数据
     * @return List<AddressInfo>
     */
    List<AddressInfo> getList(AddressInfoQueryDTO dto) throws ValidationException;

    /**
    * 批量删除客户地址信息
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
