package com.oss.ossdemo.service.impl;


import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.*;
import com.oss.ossdemo.config.OssConfig;
import com.oss.ossdemo.service.UpLoadService;
import com.oss.ossdemo.util.OssClientUtil;
import lombok.extern.slf4j.Slf4j;
import netscape.javascript.JSObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Date;

@Service
@Slf4j
public class UpLoadServiceImpl implements UpLoadService {


    @Resource
    OssConfig ossConfig;



    public void streamUpLoad(String bucketName,String objectName) {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(
                ossConfig.getEndpoint(),
                ossConfig.getAccessKeyId(),
                ossConfig.getAccessKeySecret()
                );
        // 创建PutObjectRequest对象。
        String content = "Hello OSS"; // 字符串上传
        byte[] bytes = content.getBytes();// 上传Byte数组

        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
        //PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(bytes));  // 上传byte数组

        // 如果上传时设置存储类型与访问权限，
//         ObjectMetadata metadata = new ObjectMetadata();
//         metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
//         metadata.setObjectAcl(CannedAccessControlList.Private);
//         putObjectRequest.setMetadata(metadata);

        // 上传字符串/Byte数组
        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient
        ossClient.shutdown();
    }

    @Override
    public void upLoadFileStream(String key, InputStream inputStream) {
        log.info("上传到oss文件参数:key,文件名"+ key );

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(
                ossConfig.getEndpoint(),
                ossConfig.getAccessKeyId(),
                ossConfig.getAccessKeySecret()
        );

        // 获取下载地址
        // key : 表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg
        ossClient.putObject(ossConfig.getBucketName(), key, inputStream);
        URL url = getUrl(key);
        log.info("上传成功");
        log.info("URL =" + JSONObject.toJSONString(url));

    }

    /**oss获取文件下载路径；
     * @param key
     * @return
     */
    public URL getUrl(String key){
        OSS ossClient = new OSSClientBuilder().build(
                ossConfig.getEndpoint(),
                ossConfig.getAccessKeyId(),
                ossConfig.getAccessKeySecret()
        );
        // 设置URL过期时间为1小时
        Date expiration = new Date(new Date().getTime() + 3600 * 10000);
        // 生成URL
        URL url = ossClient.generatePresignedUrl(ossConfig.getBucketName(), key, expiration);
        return url;
    }
    @Override
    public void formUpLoad() {

    }


}
