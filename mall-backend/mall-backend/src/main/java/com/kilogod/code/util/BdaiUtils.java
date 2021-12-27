package com.kilogod.code.util;

import com.kilogod.code.domain.bd.TransAddress;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.beans.IntrospectionException;
import java.util.Map;

/**
 * @author anding
 * @Description: 百度ai
 */
@Slf4j
@Component
public class BdaiUtils {

    private static String appid;

    private static String appkey;

    private static String secretkey;

    public static String getToken(){
        String url="https://aip.baidubce.com/oauth/2.0/token?grant_type=client_credentials&client_id="+appkey+"&client_secret="+secretkey;
        log.info("百度AI请求TOKEN的链接："+url);
        Map map = HttpUtils.getInstance().sendHttpPost(url);
        String token=null;
        if (map!=null){
            token=(String) map.get("access_token");
        }
        log.info("百度AI的TOKEN是："+token);
        return token;
    }


    public static TransAddress getAddressInfo(String text) throws IllegalAccessException, IntrospectionException, InstantiationException {
        String url="https://aip.baidubce.com/rpc/2.0/nlp/v1/address?charset=UTF-8&access_token="+getToken();
        JSONObject jsonObject=new JSONObject();
        jsonObject.append("text",text);
        Map mapAddress = HttpUtils.getInstance().sendHttpPost(url, jsonObject.toString());
        log.info("地址识别的结果："+mapAddress.toString());
        TransAddress address=null;
        if (null!= mapAddress.get("province")){
            address = MapUtils.parseMap2Object(mapAddress,TransAddress.class);
        }
        return address;
    }


    @Value("${bdai.appid}")
    public void setAppid(String appid) {
        BdaiUtils.appid = appid;
    }

    @Value("${bdai.appkey}")
    public void setAppkey(String appkey) {
        BdaiUtils.appkey = appkey;
    }

    @Value("${bdai.secretkey}")
    public void setSecretkey(String secretkey) {
        BdaiUtils.secretkey = secretkey;
    }

}
