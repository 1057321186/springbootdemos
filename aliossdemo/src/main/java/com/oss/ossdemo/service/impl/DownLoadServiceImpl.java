package com.oss.ossdemo.service.impl;

import com.aliyun.oss.ClientBuilderConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.GetObjectRequest;
import com.oss.ossdemo.config.OssConfig;
import com.oss.ossdemo.service.DownLoadService;
import com.oss.ossdemo.util.OssClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;

@Service
@Slf4j
public class DownLoadServiceImpl implements DownLoadService {


    @Resource
    OssConfig ossConfig;

    @Override
    public void downLoadFile(String key) {
        ClientBuilderConfiguration conf = new ClientBuilderConfiguration();

        // 设置是否支持CNAME。CNAME是指将自定义域名绑定到存储空间上。
        conf.setSupportCname(true);
        OSS ossClient = new OSSClientBuilder().build(
                ossConfig.getEndpoint(),
                ossConfig.getAccessKeyId(),
                ossConfig.getAccessKeySecret(),
                conf);

        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest("rxlbucket", key),
                new File("F:\\"+key));
        log.info("下载成功");

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
