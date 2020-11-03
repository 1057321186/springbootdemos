package com.oss.ossdemo.service.impl;


import com.aliyun.oss.OSS;
import com.aliyun.oss.model.Bucket;
import com.oss.ossdemo.service.BucketService;
import com.oss.ossdemo.util.OssClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BucketServiceImpl implements BucketService {



    @Override
    public void deleteBucket(String bucketName) {

        // 创建OSSClient
        OSS ossClient = OssClientUtil.createOssClient();

        // 删除存储空间。
        ossClient.deleteBucket(bucketName);

    }

    @Override
    public void createBucket(String bucketName) {
        // 创建OSSClient
        OSS ossClient = OssClientUtil.createOssClient();
        Bucket bucket = null;

        // 判断Bucket是否存在
        if (ossClient.doesBucketExist(bucketName)) {
            System.out.println("您已经创建Bucket：" + bucketName + "。");
        } else {
            System.out.println("您的Bucket不存在，创建Bucket：" + bucketName + "。");
            // 创建Bucket
            bucket = ossClient.createBucket(bucketName);
        }

        log.info(bucket.getLocation());
        log.info(bucket.getExtranetEndpoint());
        log.info(bucket.getIntranetEndpoint());
        log.info(bucket.getRegion());


    }


}
