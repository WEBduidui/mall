package com.kilogod.code.util;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 * @author anding
 * @Description:
 */
@Component
public class QiniuUtils {

    public static String accessKey;

    public static String secretKey;

    public static String bucket;

    @Value("${qn.oss.accessKey}")
    public void setAccessKey(String accessKey) {
        QiniuUtils.accessKey = accessKey;
    }

    @Value("${qn.oss.secretKey}")
    public void setSecretKey(String secretKey) {
        QiniuUtils.secretKey = secretKey;
    }

    @Value("${qn.oss.bucket}")
    public void setBucket(String bucket) {
        QiniuUtils.bucket = bucket;
    }

    public static String uploadFileByte(byte[] upload){
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        System.out.println(upToken);


        //构造一个带指定 Region 对象的配置类
        Configuration cfg = new Configuration(Region.region2());
        //...其他参数参考类注释

        UploadManager uploadManager = new UploadManager(cfg);
        //...生成上传凭证，然后准备上传

        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = null;

        //            byte[] uploadBytes = "hello qiniu cloud".getBytes("utf-8");
        ByteArrayInputStream byteInputStream=new ByteArrayInputStream(upload);

        try {
            Response response = uploadManager.put(byteInputStream,key,upToken,null, null);
            //解析上传成功的结果
            DefaultPutRet putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            System.out.println(putRet.key);
            System.out.println(putRet.hash);
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
        }
        return key;
    }

    public static String uploadMultipartFile(MultipartFile multipartFile) throws IOException {
        return uploadFileByte(multipartFile.getBytes());
    }

}
