package com.kilogod.code.controller;

import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.domain.dto.SmsInfoDTO;
import com.kilogod.code.domain.dto.SmsNameInfoDTO;
import com.kilogod.code.service.ISmsInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

/**
 * @author anding
 * @description
 */
@Api(tags = "短信服务")
@RestController
@RequestMapping("/sms")
public class SmsInfoController {

    @Autowired
    private ISmsInfoService smsInfoService;

    @ApiOperation("发送短息")
    @PostMapping("/sendSms")
    public ResultData sendSms(@RequestBody SmsInfoDTO dto){
        ResultData rc = new ResultData();
        try {
            rc=smsInfoService.sendSms(dto);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
        } catch (Exception e) {
            rc.setErrorMsg("验证码发送出错！");
        }
        return rc;
    }

    @ApiOperation("校验短信验证码")
    @PostMapping("/validateSms")
    public ResultData validateSms(@RequestBody SmsInfoDTO dto){
        ResultData rc = new ResultData();
        try {
            rc.setData(smsInfoService.validateSms(dto));
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
        } catch (Exception e) {
            rc.setError("验证码发送出错！");
        }
        return rc;
    }

    @ApiOperation("发送短息通过自定义模板")
    @PostMapping("/sendSmsName")
    public ResultData sendSmsName(@RequestBody SmsNameInfoDTO dto){
        ResultData rc = new ResultData();
        try {
            rc=smsInfoService.sendSmsName(dto);
        } catch (ValidationException e) {
            rc.setError(e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            rc.setErrorMsg("验证发送出错！");
            e.printStackTrace();
        }
        return rc;
    }
}
