package com.kilogod.code.controller;

import com.alipay.api.AlipayApiException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.config.annotation.validateuser.ValidateUser;
import com.kilogod.code.domain.PayInfo;
import com.kilogod.code.domain.dto.PayInfoDTO;
import com.kilogod.code.domain.dto.PayInfoQueryDTO;
import com.kilogod.code.domain.vo.AlipayTradeCloseVO;
import com.kilogod.code.domain.vo.AlipayTradeQueryVO;
import com.kilogod.code.domain.vo.UserInfoVO;
import com.kilogod.code.service.IPayInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.ValidationException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * <p>
 * 支付订单表 前端控制器
 * </p>
 *
 * @author Anding
 * @since
 */
@Slf4j
@Api(tags = {"支付订单表"})
@RestController
@RequestMapping("/payinfo")
public class PayInfoController {

    @Autowired
    private IPayInfoService payInfoService;


    @PostMapping("/insert")
    @ApiOperation(value = "新增支付订单表")
    public ResultData insert(@RequestBody PayInfoDTO dto, @ValidateUser UserInfoVO vo){
        ResultData rc = new ResultData();
        try {
            if (!dto.getUserId().equals(vo.getId())){
                log.info("拉起支付请求用户id与解析用户id不一致！");
                rc.setErrorMsg("数据篡改！");
                return rc;
            }
            rc.setData(payInfoService.insert(dto));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除支付订单表")
    public ResultData delete(@RequestParam String id){
        ResultData rc = new ResultData();
        try {
            rc.setData(payInfoService.delete(id));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @PutMapping("/update")
    @ApiOperation(value = "更新支付订单表")
    public ResultData update(@RequestBody PayInfo payInfo){
        ResultData rc = new ResultData();
        try {
            rc.setData(payInfoService.updateData(payInfo));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/list")
    @ApiOperation(value = "查询支付订单表分页数据")
    public ResultData<PageInfo<PayInfo>> getList(PayInfoQueryDTO dto){
        ResultData rc = new ResultData();
        try {
            PageHelper.startPage(dto.getPage(), dto.getSize());
            List<PayInfo> list = payInfoService.getList(dto);
            PageInfo<PayInfo> data = new PageInfo<>(list);
            rc.setData(data);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }



    @PostMapping("/batchDelete")
    @ApiOperation(value = "批量删除支付订单表")
    public ResultData batchDelete(@RequestBody List<Integer> ids) {
        ResultData rc = new ResultData();
        try {
            rc.setData(payInfoService.batchDelete(ids));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }


    /**
     * 支付宝服务器异步通知页面
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     * @throws AlipayApiException
     */
    @RequestMapping("/notifyUrl")
    @ApiOperation(value = "支付宝服务器异步通知页面")
    public String notifyUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException, ValidationException {
        return payInfoService.notifyUrl(request);
    }

    /**
     * 支付宝服务器同步通知页面
     * @param request
     * @return
     * @throws UnsupportedEncodingException
     * @throws AlipayApiException
     */
    @RequestMapping("/returnUrl")
    @ApiOperation(value = "支付宝服务器同步通知页面")
    public String returnUrl(HttpServletRequest request) throws UnsupportedEncodingException, AlipayApiException {
        return payInfoService.returnUrl(request);
    }

    @GetMapping("/payQuery")
    @ApiOperation(value = "交易查询")
    public ResultData tradequery(@RequestParam(required=false) String tradeNo,
                                 @RequestParam(required=false) String outTradeNo){
        ResultData rc = new ResultData();
        try {
            AlipayTradeQueryVO tradequery = payInfoService.tradequery(tradeNo, outTradeNo);
            rc.setData(tradequery);
        } catch (ValidationException e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

    @GetMapping("/tradeClose")
    @ApiOperation(value = "交易关闭")
    public ResultData tradeClose(@RequestParam(required=false) String tradeNo,
                                 @RequestParam(required=false) String outTradeNo,
                                 @RequestParam(required = false) String operatorId){
        ResultData rc = new ResultData();
        try {
            AlipayTradeCloseVO tradeClose=payInfoService.tradeClose(tradeNo, outTradeNo, operatorId);
            rc.setData(tradeClose);
        } catch (ValidationException e) {
            rc.setErrorMsg(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setError();
            e.printStackTrace();
        }
        return rc;
    }

}
