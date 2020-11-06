package com.oss.ossdemo.util;


import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Bucket;
import com.aliyun.oss.model.CreateBucketRequest;
import com.oss.ossdemo.config.OssConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class OssClientUtil {

    @Autowired
    OssConfig ossConfig;

    /**
     * TODO: 访问秘钥和加密签名字符串通过配置文件获取，弃用工具类
     *
     */

    // 访问域名
    private static final String endpoint = "http://oss-cn-beijing.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
    // 访问秘钥（用于标识用户）
    private static final String accessKeyId = "";
    // 用户用于加密签名字符串和OSS用来验证签名字符串的密钥，必须保密
    private static final String accessKeySecret = "";
    // 存储空间名字
    private static final String bucketName = "rxlbucket";
    //
    private static final String firstKey = "first_object";

//    ClientConfiguration是OSSClient的配置类，您可通过此类来配置代理、连接超时、最大连接数等参数

    /**
     * 创建OSSClient
     * @return
     */
    public static OSS createOssClient(){

        ClientBuilderConfiguration conf = new ClientBuilderConfiguration();

        // 设置是否支持CNAME。CNAME是指将自定义域名绑定到存储空间上。
        conf.setSupportCname(true);
        OSS ossClient = new OSSClientBuilder().build(
                endpoint,
                accessKeyId,
                accessKeySecret,
                conf);

        return ossClient;

        // 关闭OSSClient。
//        ossClient.shutdown();
    }


    /**
     * 创建Bucket
     * @param bucketName
     * @return
     */
    public static Bucket createBucket(String bucketName){

        OSS ossClient = createOssClient();
        // 创建CreateBucketRequest对象。
        CreateBucketRequest createBucketRequest = new CreateBucketRequest(bucketName);

        // 如果创建存储空间的同时需要指定存储类型以及数据容灾类型, 可以参考以下代码。
        // 此处以设置存储空间的存储类型为标准存储为例。
        // createBucketRequest.setStorageClass(StorageClass.Standard);
        // 默认情况下，数据容灾类型为本地冗余存储，即DataRedundancyType.LRS。如果需要设置数据容灾类型为同城冗余存储，请替换为DataRedundancyType.ZRS。
        // createBucketRequest.setDataRedundancyType(DataRedundancyType.ZRS)

        // 创建存储空间。
        Bucket bucket = ossClient.createBucket(createBucketRequest);

        return bucket;
    }



}
