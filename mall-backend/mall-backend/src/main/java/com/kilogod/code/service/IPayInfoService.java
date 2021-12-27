package com.kilogod.code.service;

import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.extension.service.IService;
import com.kilogod.code.domain.PayInfo;
import com.kilogod.code.domain.dto.PayInfoDTO;
import com.kilogod.code.domain.dto.PayInfoQueryDTO;
import com.kilogod.code.domain.vo.AlipayTradeCloseVO;
import com.kilogod.code.domain.vo.AlipayTradeQueryVO;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * <p>
 * 支付订单表 服务类
 * </p>
 *
 * @author Anding
 * @since
 */
public interface IPayInfoService extends IService<PayInfo> {

    /**
    * 添加支付订单表
    *
    * @param dto 支付订单表
    * @return int
    * @throws ValidationException
    */
    String insert(PayInfoDTO dto) throws ValidationException, UnsupportedEncodingException, AlipayApiException;

    /**
    * 删除支付订单表
    *
    * @param id 主键
    * @return int
    * @throws ValidationException
    */
    int delete(String id) throws ValidationException;

    /**
    * 修改支付订单表
    *
    * @param payInfo 支付订单表
    * @return int
    * @throws ValidationException
    */
    int updateData(PayInfo payInfo) throws ValidationException;

    /**
     * 查询支付订单表分页数据
     * @return List<PayInfo>
     */
    List<PayInfo> getList(PayInfoQueryDTO dto) throws ValidationException;

    /**
    * 批量删除支付订单表
    * @param ids
    * @return
    * @throws ValidationException
    */
    int batchDelete(List<Integer> ids) throws ValidationException;

    
    /**
     * @Author anding
     * @Param [exPayInfo]
     * @return int 
     * @Description 修改信息
     **/
    int updateByOutTradeNo(PayInfo exPayInfo) throws ValidationException;

    /**
     * 支付宝服务器异步通知页面
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     * @throws AlipayApiException
     * @throws ValidationException
     */
    String notifyUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException, ValidationException;

    /**
     * 支付宝服务器同步通知页面
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     * @throws AlipayApiException
     */
    String returnUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException;

    /**
     * 交易查询
     * @param tradeNo
     * @param outTradeNo
     * @return
     * @throws UnsupportedEncodingException
     * @throws AlipayApiException
     * @throws ValidationException
     */
    AlipayTradeQueryVO tradequery(String tradeNo, String outTradeNo) throws UnsupportedEncodingException, AlipayApiException, ValidationException;

    AlipayTradeCloseVO tradeClose(String tradeNo, String outTradeNo, String operatorId) throws AlipayApiException, ValidationException;

}
