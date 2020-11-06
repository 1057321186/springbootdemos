package com.oss.ossdemo.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.Serializable;

@Getter
@Setter
@PropertySource(value = {"classpath:oss.properties"},encoding = "UTF-8")
@Configuration
public class OssConfig implements Serializable {

    /**
     * 访问域名
     */
    @Value("${aliyun.endpoint}")
    String endpoint;

    /**
     * 访问秘钥（用于标识用户）
     */
    @Value("${aliyun.accessKeyId}")
    String accessKeyId;

    /**
     * 用户用于加密签名字符串和OSS用来验证签名字符串的密钥，必须保密
     */
    @Value("${aliyun.accessKeySecret}")
    String accessKeySecret;

    /**
     * 存储空间
     */
    @Value("${aliyun.bucketName}")
    String bucketName;


    String firstKey;

    /**
     * 盐
     */
    @Value("${aliyun.password}")
    String password;

}
