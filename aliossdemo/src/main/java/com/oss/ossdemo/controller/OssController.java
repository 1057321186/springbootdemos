package com.oss.ossdemo.controller;

import com.oss.ossdemo.config.OssConfig;
import com.oss.ossdemo.service.BucketService;
import com.oss.ossdemo.service.DownLoadService;
import com.oss.ossdemo.service.UpLoadService;
import com.oss.ossdemo.vo.ApiResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;


@RestController
@Slf4j
public class OssController {

    @Resource
    OssConfig ossConfig;

    @Resource
    BucketService bucketService;

    @Resource
    UpLoadService upLoadService;

    @Resource
    DownLoadService downLoadService;


    @PostMapping("/uploadExcel")
    public ApiResult upLoadExcel(@RequestParam MultipartFile file, HttpServletRequest request) {
        log.info("上传文件={}" + file.getOriginalFilename());

        ApiResult result = new ApiResult();

        // ObjectName
        String key = UUID.randomUUID() + file.getOriginalFilename();
        log.info("key = " + key);
        if(!key.endsWith(".xlsx") && !key.endsWith(".xls")){
            log.error("文件格式不对");
            result.error("导入文件格式不对");
            return result;
        }

        InputStream inputStream = null;
        try {
            inputStream = file.getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }

        upLoadService.upLoadFileStream(key,inputStream);
        return result;
    }


    /**
     * 下载文件到本地
     * @param key
     */
    @GetMapping("/downLoad")
    public ApiResult downLoad(String key){
        log.info("key = " + key);
        ApiResult result = new ApiResult();
        downLoadService.downLoadFile(key);

        return result;
    }




}
