package com.kilogod.code.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.TradeSerial;
import com.kilogod.code.domain.dto.TradeSerialQueryDTO;

import javax.xml.bind.ValidationException;
import java.util.List;

/**
 * <p>
 * 交易流水 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface ITradeSerialService extends IService<TradeSerial> {

    /**
    * 添加交易流水
    *
    * @param tradeSerial 交易流水
    * @return int
    * @throws ValidationException
    */
    int insert(TradeSerial tradeSerial) throws ValidationException;

    /**
    * 删除交易流水
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改交易流水
    *
    * @param tradeSerial 交易流水
    * @return int
    * @throws ValidationException
    */
    int updateData(TradeSerial tradeSerial) throws ValidationException;

    /**
     * 查询交易流水分页数据
     * @return List<TradeSerial>
     */
    List<TradeSerial> getList(TradeSerialQueryDTO dto) throws ValidationException;

    List<TradeSerial> getListByAdmin(TradeSerialQueryDTO dto) throws ValidationException;

    /**
    * 批量删除交易流水
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

}
