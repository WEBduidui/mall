package com.kilogod.code.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */
@Component
public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
//	public static String app_id = "2016102200741134";
//    public static String app_id = "2021001164650072";
    public static String app_id;

    // 商户私钥，您的PKCS8格式RSA2私钥
//    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCAn9Q7VrEUf3WSJrB3lab2P+t4ptlzSBQa/4sKb3YXBwHRy7OaaI6W1MJ3P6gvkYZK9AgSAGAPOrvmfUwzeFXy46tasoHrQxzVzfiheMSkxTjm7A6+uugxSiU3a4vKrbOHTm4HHVluInxGWVNZf9PokLp/tXDggbmh3F17GmFC0nQNyQ0cMHro1LGUpWCZT3wWhmojiXAvd8PFzdp35wNaBhJXurNjL8D5PWMf5ZQ6/7CvEleCSbczWtLy4Osn03qP48QnYxWYlSCstXNEL2Xcefqj/BjcrrtB1axR82N2/uIG7fY7F4m7QkPjhveysgxgTsEZIz8tddztuTy7hi6JAgMBAAECggEAeYWH4GAxgapCjEidZP4w9mrBsAYDYBVzWWaiGMPiEDOAlpQcJgAu53YwHLY50mdtN5eDoG5WU00shcFPozlICujq1g/dC0cnESE+jGAreXkUH6ha7fxsr1TcAJZNRroB6g5BidtCyPkv7M8sHlzU+t7yNQJZmOM3XSNz9oCf7567cm/f1N5/5uU7Ro6lpSSVTbyCBsONRIs1NNbW90WxMif6idS3ODuAoTmkLXQglrn7bql8sK0QPKMFHxEoFkfuteZMWU1SaQaVbUAGUop7dI1wuPOoyVRgL7uwSt+ONF+TFByLOSIr2Eq68vmQYT6eI6BFQqImh4U96KjkFPIMAQKBgQD1jMc+A3GFMlie6Tpr9Yy8ElPeO97VnlFIOK+7vhiXSIE2ar/DLso/onUq91KKEzI5QJAzhf45ZpCZ9+hEwHt3O5eVbRWitwkpUMEvmSI+1tnaxXB4fk47LWjnQ7zOPvmeSsKlUT493yF3zV1s1tp9yUiLhnFCCN2GFK4/vVn7SQKBgQCGGSryNkgMY5ETUt+nuwddSIALaF3s2fcV8ygtCfrXXhwhGt41GzkBlHWfbwzAPD/eFJRE1myDlumFkUaY3IP1acr2OjE4NgbqiN+mxy/9YACAsH5nx6DVy7luegzFNmA+Djc+IsqqF2w4zwFh7qAEQ9x40jIDUj2sCRUfe8lZQQKBgQCZKbHSBbXWnnvWy6XsV2LsoQX9Vhz95F3RDcLX+ZA/NTOb7OQmbFYtcTlijpjGlYi7W4FXEhpsVYSW9aLE18drrRk1VLCtKTymr7+A4CUTS1LiektYbXiAwydvMbpgb7mmOf3FvrJzR24J22iODkqFMXt1xGt7BCqhit7R1Vt+OQKBgCKdWoWdV2nDRc6cJNlyIMuGjG7laOFbvjkvRB6kJdj0FQTCn7tLpKJwxQ/7pWn143KbE07Vnrs0+GCfCH8q5PEzds2qZcwhvhVKcZjmb8/SuS5+4JI/aJfnd5056hP6HkvGdaIXbwMK+seLP8scwrd3IPEbKQfMcdj3mzk+RdJBAoGAUuEVG3eWjj5u5S4Vr7KKnzmR/8PqL5SzyXezGLMblJ7TBv8rlZUb5J/Q46UkTSw97tRggr1SXLtDDdxDg/AgemPGxHA+Kf3J03EhuDgNa9DUUZu2Ji9jm8izgLHP6RANFklzRC5loHW7SbDIAvPJU41ubK+Har8Vxua9TyfOPKw=";
    public static String merchant_private_key;
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
//  public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAnlFOU+cDU5w6HrRqJDyVgcFz0CpKdnMVEAncrdQMjf/X9YRgJaqY2v/AeVXJK6zvtF8I+SfStng0C8YzqsrlI+mT0eb5hhG3ECXz0AtCJj4tBcqmFJjDhYzML14hVb0q6e52zHDKFe4JvMvWLSwt2HOC3B5ac6Un9+KEheNmJEWTJ/+Cv4IesXvvIoaK2RPaIM4uxYrEPTplnTSe3nzLfKwNrgC8eU3FXAzJ1GCpTZeVDmjSOBixG6JVd7R4TKngeE4tLUInYc19aRB4PBU8JcGZ14lU8abcdEyJxI7Vp0A3hmhRADQOPJT/rdaJTwgZ1RFgQMTT8jfDksdIrp42uwIDAQAB";
//    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAqzGMlgagA1KDMrlwtRVf2FxG2ZgCBYcip4a0+NAxuOkj/KKHDzhXoPPMpBw38LhMyDbAQk1TeIoYep2J8gbLzCYsojC5R+HQT42rJl8PN6T8H4vMMs4jVp2C/MtMdsyKJ+SuXaWJXOCKPP/uu2CaZbC+jfoYJDSfSs1oWSqJNfaWoyHEnDg9bgQo2p+WaFUp5k80qhAqhaCnYBuZATLkmFslPUxHsDW/zLZaNaI/IqQqaP9TwqDh38sSoeJFay4PdXe9qwIKUwCG9S6cLBQAYTxB+5jCHLdMyehfXjuTtQyD9hCmYLxd3cohAGlz8m9Du3fiWWz6d/8yjt/CMwX+nQIDAQAB";
    public static String alipay_public_key;

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 http://47.113.104.193:8002/expayinfo/notifyUrl
	public static String notify_url;

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问  http://47.113.104.193:8002/expayinfo/returnUrl
	public static String return_url;

	// 签名方式 RSA2
	public static String sign_type;
	
	// 字符编码格式 utf-8
	public static String charset;
	
	// 支付宝网关
//	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do"; https://openapi.alipay.com/gateway.do
    public static String gatewayUrl;
	
	// 支付宝网关
	public static String log_path;


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    @Value("${alipay.app_id}")
    public  void setApp_id(String app_id) {
        AlipayConfig.app_id = app_id;
    }

    @Value("${alipay.merchant_private_key}")
    public  void setMerchant_private_key(String merchant_private_key) {
        AlipayConfig.merchant_private_key = merchant_private_key;
    }

    @Value("${alipay.alipay_public_key}")
    public  void setAlipay_public_key(String alipay_public_key) {
        AlipayConfig.alipay_public_key = alipay_public_key;
    }

    @Value("${alipay.notify_url}")
    public  void setNotify_url(String notify_url) {
        AlipayConfig.notify_url = notify_url;
    }

    @Value("${alipay.return_url}")
    public  void setReturn_url(String return_url) {
        AlipayConfig.return_url = return_url;
    }

    @Value("${alipay.sign_type}")
    public  void setSign_type(String sign_type) {
        AlipayConfig.sign_type = sign_type;
    }

    @Value("${alipay.charset}")
    public  void setCharset(String charset) {
        AlipayConfig.charset = charset;
    }

    @Value("${alipay.gatewayUrl}")
    public  void setGatewayUrl(String gatewayUrl) {
        AlipayConfig.gatewayUrl = gatewayUrl;
    }

    @Value("${alipay.log_path}")
    public  void setLog_path(String log_path) {
        AlipayConfig.log_path = log_path;
    }
}

