package com.oss.ossdemo;

import com.alibaba.fastjson.JSONObject;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.google.common.collect.Maps;
import com.oss.ossdemo.config.OssConfig;
import com.oss.ossdemo.service.UpLoadService;
import com.oss.ossdemo.util.OssClientUtil;
import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@SpringBootTest
class OssdemoApplicationTests {
    public static final String DATETIME_FOMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String DATETIME_FOMAT_PAYTIME = "yyyyMMddHHmmss";
    public static final String DATETIME_FORMAT_4_MONITOR = "yyyy/MM/dd HH:mm:ss";
    public static final String Mill_DATETIME_FORMAT_4_MONITOR = "yyyy/MM/dd HH:mm:ss.SSS";
    public static final String DATE_FOMAT = "yyyy-MM-dd";
    public static final String TIME_FOMAT = "HH:mm:ss";

    @Resource
    OssConfig ossConfig;

    @Resource
    UpLoadService upLoadService;

    @Resource
    private StringEncryptor stringEncryptor;

    @Resource
    private RestTemplate restTemplate;




    @Test
    void createBucket(){

        String bucketName = "rxlbucket-1";
        Bucket bucket = OssClientUtil.createBucket(bucketName);
        log.info(bucket.getLocation());
        log.info(bucket.getExtranetEndpoint());
        log.info(bucket.getIntranetEndpoint());
        log.info(bucket.getRegion());

    }

    @Test
    void showBucketInfo(){
        // 创建OSSClient
        OSS ossClient = OssClientUtil.createOssClient();

        String bucketName = "rxlbucket-1";

        // 获取指定存储空间对象
        BucketInfo info = ossClient.getBucketInfo(bucketName);

        // 存储空间信息
        System.out.println("Bucket " + bucketName + "的信息如下：");
        System.out.println("\t获取地域：" + info.getBucket().getLocation());
        System.out.println("\t创建时间：" + info.getBucket().getCreationDate());
        System.out.println("\t获取拥有者信息：" + info.getBucket().getOwner());
        System.out.println("\t地域：" + info.getBucket().getRegion());
        System.out.println("\t获取权限信息：" + info.getGrants());
        System.out.println("\t获取容灾类型：" + info.getDataRedundancyType());


        // 列举所有存储空间对象
        List<Bucket> buckets = ossClient.listBuckets();
        for (Bucket bucket : buckets) {
            System.out.println(" - " + bucket.getName());
        }

        // 存储空间访问权限
        AccessControlList acl = ossClient.getBucketAcl(bucketName);
        System.out.println("存储空间访问权限" + acl.toString());

        // 设置存储空间的访问权限:Default、Private、PublicRead、PublicReadWrite
        ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicReadWrite);

        AccessControlList acl2 = ossClient.getBucketAcl(bucketName);
        System.out.println("存储空间访问权限" + acl2.toString());

        // 删除存储空间
//          ossClient.deleteBucket(bucketName);
    }


    @Test
    void upLoad() {

        // 创建OSSClient
        OSS ossClient = OssClientUtil.createOssClient();
        // 文件存储入OSS，Object的名称为fileKey
        String fileKey = "IC卡档案模板.xlsx";
//        ossClient.putObject("rxlbucket", fileKey, new File("C:\\Users\\Administrator\\Desktop\\IC卡档案模板.xlsx"));
        ossClient.putObject("rxlbucket", fileKey, new File("C:\\Users\\Administrator\\Desktop\\IC卡档案模板.xlsx"));
        System.out.println("Object：" + fileKey + "存入OSS成功。");

    }

    @Test
    void downLoad() throws IOException {
        OSS ossClient = OssClientUtil.createOssClient();

        // 下载OSS文件到本地文件。如果指定的本地文件存在会覆盖，不存在则新建。
        ossClient.getObject(new GetObjectRequest("rxlbucket", "运营服务相关需求文档.xlsxd64c81c4-7ccc-4dcc-bbf3-378fe4f64959"),
                new File("C:\\Users\\Administrator\\Desktop\\运营服务相关需求文档下载.xlsx"));

        // 关闭OSSClient。
        ossClient.shutdown();
        log.info("Object：" + "运营服务相关需求文档下载.xlsx" + "下载到本地成功。");


    }


    /**
     * jasypt加密，解密
     */
    @Test
    void pass(){
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

        String salt = ossConfig.getPassword();

        System.out.println(ossConfig.toString());

        log.info("加密的盐值=" + salt);
        //加密所需的salt(盐)
        textEncryptor.setPassword(salt);

        //要加密的数据（数据库的用户名或密码）
        String accessKeyId = textEncryptor.encrypt("LTAI4FyuLGbDSRBEBoFWDN4Z");
        String accessKeySecret = textEncryptor.encrypt("E47fuXngbczMkUlG1TumF57zmDYFBG");
        System.out.println("加密accessKeyId:"+accessKeyId);
        System.out.println("加密accessKeySecret:"+accessKeySecret);
        log.info("--------------------------------------------------");
        //解密
        String accessKeyId1 = textEncryptor.decrypt(accessKeyId);
        String accessKeySecret1 = textEncryptor.decrypt(accessKeySecret);
        System.out.println("解密accessKeyId:"+accessKeyId1);
        System.out.println("解密accessKeySecret:"+accessKeySecret1);

    }

    @Test
    public void test6(){
        String url = "http://127.0.0.1:8080/collect/batStateinfoList?";
        Map<String, String> params = Maps.newLinkedHashMap();
        Date date = this.parseDateTime("2020-09-08 00:00:00");
        Date endDate = this.parseDateTime("2020-09-08 23:59:59");

        params.put("size", "20");
        params.put("pageNum", "1");
        params.put("startTime", ""+date.getTime());
        params.put("endTime", ""+endDate.getTime());
        params.put("batSN", "BXC0319082200001");

        String template = restTemplate.getForObject(url + "size={size}&pageNum={pageNum}&startTime={startTime}&" +
                "endTime={endTime}&batSN={batSN}", String.class, params);

        System.out.println(template);
    }

    public static Date parseDateTime(String strDateTime) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_FOMAT);
        Date date = null;
        try {
            date = sdf.parse(strDateTime);
        } catch (Exception e) {
            log.error("日期转换异常",e);
        }
        return date;
    }
}
