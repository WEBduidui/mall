package com.kilogod.code.util;

import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.kilogod.code.domain.dto.SmsInfoDTO;
import com.kilogod.code.domain.dto.SmsNameInfoDTO;
import com.kilogod.code.mapper.SmsLogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author anding
 * @description
 */
@Slf4j
@Component
public class SendSmsUtils {

    @Resource
    private SmsLogMapper smsLogMapper;

    private static String accessKeyId;

    private static String accessSecret;

    public static String sendSms(SmsInfoDTO dto){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        String res=null;

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", dto.getPhone());
        request.putQueryParameter("SignName", "You洗同城洗衣平台");
        request.putQueryParameter("TemplateCode", "login".equals(dto.getType())?"SMS_205139555":"SMS_205139554");
        request.putQueryParameter("TemplateParam", "{\"code\":\""+dto.getCode()+"\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info("短信发送返回参数："+response.getData());
            res=response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return res;
    }

    public static String sendSmsName(SmsNameInfoDTO dto){
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessSecret);
        IAcsClient client = new DefaultAcsClient(profile);

        String res=null;

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", dto.getPhone());
        request.putQueryParameter("SignName", "You洗同城洗衣平台");
        request.putQueryParameter("TemplateCode", dto.getTemplateCode());
        request.putQueryParameter("TemplateParam", dto.getTemplateParam());
        try {
            CommonResponse response = client.getCommonResponse(request);
            log.info("短信发送返回参数："+response.getData());
            res=response.getData();
        } catch (ServerException e) {
            e.printStackTrace();
        } catch (ClientException e) {
            e.printStackTrace();
        }
        return res;
    }

    @Value("${aliyun.sms.accessKeyId}")
    public void setAccessKeyId(String accessKeyId) {
        SendSmsUtils.accessKeyId = accessKeyId;
    }

    @Value("${aliyun.sms.accessSecret}")
    public void setAccessSecret(String accessSecret) {
        SendSmsUtils.accessSecret = accessSecret;
    }
}
