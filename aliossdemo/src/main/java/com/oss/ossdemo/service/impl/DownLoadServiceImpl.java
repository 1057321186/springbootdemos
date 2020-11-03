package com.oss.ossdemo.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.model.GetObjectRequest;
import com.oss.ossdemo.service.DownLoadService;
import com.oss.ossdemo.util.OssClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Slf4j
public class DownLoadServiceImpl implements DownLoadService {

    @Override
    public void downLoadFile(String key) {
        OSS ossClient = OssClientUtil.createOssClient();

        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest("rxlbucket", key),
                new File("F:\\"+key));
        log.info("下载成功");

        // 关闭OSSClient。
        ossClient.shutdown();
    }
}
