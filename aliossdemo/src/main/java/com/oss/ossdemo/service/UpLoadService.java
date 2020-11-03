package com.oss.ossdemo.service;

import java.io.File;
import java.io.InputStream;

public interface UpLoadService {
    /**
     * 在OSS中，操作的基本数据单元是文件（Object）
     *
     * 简单上传：包括流式上传和文件上传。最大不能超过5GB。
     *      流式上传
     *      文件上传
     * 表单上传：最大不能超过5GB。
     * 追加上传：最大不能超过5GB。
     * 断点续传上传：支持并发、断点续传、自定义分片大小。大文件上传推荐使用断点续传。最大不能超过48.8TB。
     * 分片上传：当文件较大时，可以使用分片上传，最大不能超过48.8TB。
     */


    /**
     * 上传文件流
     * @param key
     * @param inputStream
     */
    void upLoadFileStream(String key, InputStream inputStream);


    void formUpLoad();

}
