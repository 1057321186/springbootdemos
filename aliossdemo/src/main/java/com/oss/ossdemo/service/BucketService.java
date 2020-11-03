package com.oss.ossdemo.service;

public interface BucketService {


        /**
         * 删除存储空间
         * @param bucketName
         */
        void deleteBucket(String bucketName);

        /**
         * 创建存储空间
         * @param bucketName
         */
        void createBucket(String bucketName);
}
