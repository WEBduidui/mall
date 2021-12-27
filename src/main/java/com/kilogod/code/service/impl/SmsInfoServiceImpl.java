package com.kilogod.code.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.kilogod.code.common.res.ResultCode;
import com.kilogod.code.common.res.ResultData;
import com.kilogod.code.domain.SmsLog;
import com.kilogod.code.domain.User;
import com.kilogod.code.domain.dto.SmsInfoDTO;
import com.kilogod.code.domain.dto.SmsNameInfoDTO;
import com.kilogod.code.mapper.SmsLogMapper;
import com.kilogod.code.mapper.UserMapper;
import com.kilogod.code.redis.Redis;
import com.kilogod.code.service.ISmsInfoService;
import com.kilogod.code.util.SendSmsUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.bind.ValidationException;
import java.util.Map;
import java.util.Random;

/**
 * @author anding
 * @Description:
 */
@Service
public class SmsInfoServiceImpl implements ISmsInfoService {

    @Resource
    private SmsLogMapper mapper;
    @Resource
    private UserMapper userMapper;
    @Autowired
    private Redis redis;

    @Override
    public ResultData sendSms(SmsInfoDTO dto) throws ValidationException {
        ResultData rc=new ResultData();
        if ("register".equals(dto.getType())){
            User phone = userMapper.selectOne(new QueryWrapper<User>().eq("phone", dto.getPhone()));
            if (phone!=null){
                rc.setError(ResultCode.phone_IS_EXIST);
                return rc;
            }
        }
        if (StringUtils.isBlank(dto.getType())){
            rc.setError(ResultCode.PARAMS_IS_NOT_NULL);
            return rc;
        }
        if (StringUtils.isBlank(dto.getPhone())){
            rc.setError(ResultCode.PARAMS_IS_NOT_NULL);
            return rc;
        }
        String code = randomCode();
        redis.set("sms-"+dto.getPhone(),code);
        redis.expire("sms-"+dto.getPhone(),600);

        dto.setCode(code);
        String res = SendSmsUtils.sendSms(dto);
        Map parse = (Map) JSON.parse(res);

        SmsLog smsLog=new SmsLog();
        String message = (String) parse.get("Message");
        smsLog.setExt2((String) parse.get("RequestId"));
        if ("OK".equals(message)){
            smsLog.setStatus("1");
        }else{
            rc.setErrorMsg(message);
            smsLog.setExt1(message);
            smsLog.setStatus("0");
        }
        smsLog.setCode(code);
        smsLog.setPhone(dto.getPhone());

        int insert = mapper.insert(smsLog);
        if (insert<1){
            rc.setError(ResultCode.SMSCODE_IS_SEND_FAIL);
            return rc;
        }
        return rc;
    }

    @Override
    public boolean validateSms(SmsInfoDTO dto) throws ValidationException {
        if (StringUtils.isBlank(dto.getCode())){
            throw new ValidationException(ResultCode.PARAMS_IS_NOT_NULL);
        }
        if (StringUtils.isBlank(dto.getPhone())){
            throw new ValidationException(ResultCode.PARAMS_IS_NOT_NULL);
        }
        String code = redis.get("sms-"+dto.getPhone());
        if (!dto.getCode().equals(code)){
            throw new ValidationException(ResultCode.MSG_CODE_ERROR);
        }
        return true;
    }

    @Override
    public ResultData sendSmsName(SmsNameInfoDTO dto) throws ValidationException {
        ResultData rc=new ResultData();
        if (StringUtils.isBlank(dto.getPhone())){
            rc.setError(ResultCode.PARAMS_IS_NOT_NULL);
            return rc;
        }
        if (dto.getTemplateParam().indexOf("code")>-1){
            String code = randomCode();
            redis.set("resetpwd-"+dto.getPhone(),code);
            redis.expire("resetpwd-"+dto.getPhone(),600);
            dto.setTemplateParam("{\"code\":\""+code+"\"}");
        }

        String res = SendSmsUtils.sendSmsName(dto);
        Map parse = (Map) JSON.parse(res);

        SmsLog smsLog=new SmsLog();
        String message = (String) parse.get("Message");
        smsLog.setExt2((String) parse.get("RequestId"));
        if ("OK".equals(message)){
            smsLog.setStatus("1");
        }else{
            rc.setErrorMsg(message);
            smsLog.setExt1(message);
            smsLog.setStatus("0");
        }
        smsLog.setCode(dto.getTemplateParam());
        smsLog.setPhone(dto.getPhone());

        int insert = mapper.insert(smsLog);
        if (insert<1){
            rc.setError(ResultCode.SMSCODE_IS_SEND_FAIL);
            return rc;
        }
        return rc;
    }

    private String randomCode() {
        StringBuilder str = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            str.append(random.nextInt(10));
        }
        return str.toString();
    }
}
