# 对象存储OSS（Object Storage Service）

## 简介

###  **什么是对象存储**OSS

阿里云对象存储OSS（Object Storage Service）是阿里云提供的海量、安全、低成本、高持久的**云存储服务**。其数据设计持久性不低于99.9999999999%（12个9），服务可用性（或业务连续性）不低于99.995%。

OSS具有与平台无关的RESTful API接口，您可以在任何应用、任何时间、任何地点存储和访问任意类型的数据。

您可以使用阿里云提供的API、SDK接口或者OSS迁移工具轻松地将海量数据移入或移出阿里云OSS。数据存储到阿里云OSS以后，您可以选择标准存储（Standard）作为移动应用、大型网站、图片分享或热点音视频的主要存储方式，也可以选择成本更低、存储期限更长的低频访问存储（Infrequent Access）、归档存储（Archive）、冷归档存储（Cold Archive）作为不经常访问数据的存储方式。

### **产品优势**

阿里云对象存储OSS，是阿里云提供的海量、安全、低成本、高持久性的云存储服务。本文将OSS与传统的自建存储进行对比，让您更好的了解OSS

#### 1、OSS与自建存储对比的优势

| 对比项   |                         对象存储OSS                          |                        自建服务器存储                        |
| :------- | :----------------------------------------------------------: | :----------------------------------------------------------: |
| 持久性   | OSS作为阿里巴巴全集团数据存储的核心基础设施，多年支撑双11业务高峰，历经高可用与高可靠的严苛考验。OSS的多重冗余架构设计，为数据持久存储提供可靠保障。同时，OSS基于高可用架构设计，消除单点故障，确保数据业务的持续性。服务可用性不低于99.995%。数据设计持久性不低于99.9999999999%（12个9）。规模自动扩展，不影响对外服务。数据自动多重冗余备份。 | 受限于硬件持久性，易出问题，一旦出现磁盘坏道，容易出现不可逆转的数据丢失。人工数据恢复困难、耗时、耗力。 |
| 安全     | 提供企业级多层次安全防护，包括服务端加密、客户端加密、防盗链、IP黑白名单、细粒度权限管控、日志审计、WORM特性等。多用户资源隔离机制，支持异地容灾机制。获得多项合规认证，包括SEC、FINRA等，满足企业数据安全与合规要求。 |      需要另外购买清洗和黑洞设备。需要单独实现安全机制。      |
| 成本     | 多线BGP骨干网络，带宽资源充足，上行流量免费。无需运维人员与托管费用，0成本运维。 | 存储受硬盘容量限制，需人工扩容。单线或双线接入速度慢，有带宽限制，峰值时期需人工扩容。需专人运维，成本高。 |
| 智能存储 | 提供多种数据处理能力，如图片处理、视频截帧、文档预览、图片场景识别、人脸识别、SQL就地查询等，并无缝对接Hadoop生态、以及阿里云函数计算、EMR、DataLakeAnalytics、BatchCompute、MaxCompute、DBS等产品，满足企业数据分析与管理的需求。 |                   需要额外采购，单独部署。                   |

#### 2、OSS具备的其他各项优势

- 方便、快捷的使用方式

  - 提供标准的RESTful API接口、丰富的SDK包、客户端工具、控制台。您可以像使用文件一样方便地上传、下载、检索、管理用于Web网站或者移动应用的海量数据。
  - 不限制存储空间大小。您可以根据所需存储量无限扩展存储空间，解决了传统硬件存储扩容问题。
  - 支持流式写入和读出。特别适合视频等大文件的边写边读业务场景。
  - 支持数据生命周期管理。您可以通过设置生命周期规则，将到期数据批量删除或者转储为更低成本的低频访问、归档存储、冷归档存储。

- 强大、灵活的安全机制

  - 灵活的鉴权，授权机制。提供STS和URL鉴权和授权机制、IP黑白名单、防盗链、主子账号等功能。
  - 提供用户级别资源隔离机制和多集群同步机制（可选）。

- 数据冗余机制

  OSS采用数据冗余存储机制，将每个对象的不同冗余存储在同一个区域内多个设施的多个设备上，确保硬件失效时的数据持久性和可用性。

  - OSS Object操作具有强一致性，用户一旦收到了上传/复制成功的响应，则该上传的Object就已经立即可读，且数据已经冗余写入到多个设备中。
  - OSS会通过计算网络流量包的校验和，验证数据包在客户端和服务端之间传输中是否出错，保证数据完整传输。
  - OSS的冗余存储机制，可支持两个存储设施并发损坏时，仍维持数据不丢失。
    - 当数据存入OSS后，OSS会检测和修复丢失的冗余，确保数据持久性和可用性。
    - OSS会周期性地通过校验等方式验证数据的完整性，及时发现因硬件失效等原因造成的数据损坏。当检测到数据有部分损坏或丢失时，OSS会利用冗余的数据，进行重建并修复损坏数据。

- 丰富、强大的增值服务

  - 图片处理：支持JPG、PNG、BMP、GIF、WebP、TIFF等多种图片格式的转换，以及缩略图、剪裁、水印、缩放等多种操作。
  - 音视频转码：提供高质量、高速并行的音视频转码能力，让您的音视频文件轻松应对各种终端设备。
  - 互联网访问加速：OSS提供传输加速服务，支持上传、下载加速，可优化跨洋、跨省数据上传、下载体验。详情请参见[传输加速](https://help.aliyun.com/document_detail/131312.html#concept-1813960)。
  - 内容加速分发：OSS作为源站，搭配CDN进行内容分发，提升同一个文件，被大量重复下载的体验。

### **应用场景**

#### 1、图片和音视频等应用的海量存储

OSS可用于图片、音视频、日志等海量文件的存储。各种终端设备、Web网站程序、移动应用可以直接向OSS写入或读取数据。OSS支持<u>**流式写入**</u>和**<u>文件写入</u>**两种方式。

![image-20201029135723178](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201029135723178.png)

#### 2、网页或者移动应用的静态和动态资源分离

利用海量互联网带宽，OSS可以实现海量数据的互联网并发下载。OSS提供原生的[传输加速](https://help.aliyun.com/document_detail/131312.html?spm=a2c4g.11186623.2.11.9a3a406cUwTehT#concept-1813960)功能，支持上传加速、下载加速，提升跨国、跨洋数据上传、下载的体验。同时，OSS也可以结合CDN产品，提供静态内容存储、分发到边缘节点的解决方案，利用CDN边缘节点缓存的数据，提升同一个文件被同一地区客户大量重复并发下载的体验。

![image-20201029135839132](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201029135839132.png)

#### 3、云端数据处理

上传文件到OSS后，可以配合媒体处理服务和图片处理服务进行云端的数据处理。

![image-20201029140315408](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201029140315408.png)

### 基本概念

#### 1.存储空间（Bucket）

存储空间是用户用于存储对象（Object）的容器，所有的对象都必须隶属于某个存储空间。存储空间具有各种配置属性，包括地域、访问权限、存储类型等。用户可以根据实际需求，创建不同类型的存储空间来存储不同的数据。

- 同一个存储空间的内部是扁平的，没有文件系统的目录等概念，所有的对象都直接隶属于其对应的存储空间。
- 每个用户可以拥有多个存储空间。
- 存储空间的名称在OSS范围内必须是全局唯一的，一旦创建之后无法修改名称。
- 存储空间内部的对象数目没有限制。

存储空间的命名规范如下：

- 只能包括小写字母、数字和短划线（-）。
- 必须以小写字母或者数字开头和结尾。
- 长度必须在3~63字节之间。

##### 2.对象（Object）

对象是OSS存储数据的基本单元，也被称为OSS的文件。和传统的文件系统不同，对象没有文件目录层级结构的关系。对象由元信息（Object Meta），用户数据（Data）和文件名（Key）组成，并且由存储空间内部唯一的Key来标识。对象元信息是一组键值对，表示了对象的一些属性，比如最后修改时间、大小等信息，同时用户也可以在元信息中存储一些自定义的信息。

对象的生命周期是从上传成功到被删除为止。在整个生命周期内，除通过追加方式上传的Object可以通过继续追加上传写入数据外，其他方式上传的Object内容无法编辑，您可以通过重复上传同名的对象来覆盖之前的对象。

对象的命名规范如下：

- 使用UTF-8编码。

- 长度必须在1~1023字节之间。

- 不能以正斜线（/）或者反斜线（\）开头。

  **说明** 对象名称需要区分大小写。如无特殊说明，本文档中的对象、文件称谓等同于Object。

##### 3.ObjectKey

在各语言SDK中，ObjectKey、Key以及ObjectName是同一概念，均表示对Object执行相关操作时需要填写的Object名称。例如向某一存储空间上传Object时，ObjectKey表示上传的Object所在存储空间的完整名称，即包含文件后缀在内的完整路径，如填写为abc/efg/123.jpg。

##### 4.Region（地域）

Region表示OSS的数据中心所在物理位置。用户可以根据费用、请求来源等选择合适的地域创建Bucket。一般来说，距离用户更近的Region访问速度更快。详情请参见[OSS已经开通的Region](https://help.aliyun.com/document_detail/31837.html#concept-zt4-cvy-5db)。

Region是在创建Bucket的时候指定的，一旦指定之后就不允许更改。该Bucket下所有的Object都存储在对应的数据中心，目前不支持Object级别的Region设置。

##### 5.Endpoint（访问域名）

Endpoint表示OSS对外服务的访问域名。OSS以HTTP RESTful API的形式对外提供服务，当访问不同的Region的时候，需要不同的域名。通过内网和外网访问同一个Region所需要的Endpoint也是不同的。例如杭州Region的外网Endpoint是oss-cn-hangzhou.aliyuncs.com，内网Endpoint是oss-cn-hangzhou-internal.aliyuncs.com。具体的内容请参见[各个Region对应的Endpoint](https://help.aliyun.com/document_detail/31837.html#concept-zt4-cvy-5db)。

##### 6.AccessKey（访问密钥）

AccessKey简称AK，指的是访问身份验证中用到的AccessKeyId和AccessKeySecret。OSS通过使用AccessKeyId和AccessKeySecret对称加密的方法来验证某个请求的发送者身份。AccessKeyId用于标识用户；AccessKeySecret是用户用于加密签名字符串和OSS用来验证签名字符串的密钥，必须保密。对于OSS来说，AccessKey的来源有：

- Bucket的拥有者申请的AccessKey。
- 被Bucket的拥有者通过RAM授权给第三方请求者的AccessKey。
- 被Bucket的拥有者通过STS授权给第三方请求者的AccessKey。

更多AccessKey介绍请参见[创建AccessKey](https://help.aliyun.com/document_detail/53045.html#task968)。



## SpringBoot整合OSS



## SDK使用

```
在OSS中，操作的基本数据单元是文件（Object）
```

### 上传文件

#### 1.简单上传

##### 1.1流式上传

###### 1.1.1字符串 & Byte数组

```java
   // 创建OSSClient实例。
        OSS ossClient = OssClientUtil.createOssClient();

        // 创建PutObjectRequest对象。
        String content = "Hello OSS"; // 字符串上传
        byte[] bytes = content.getBytes();// 上传Byte数组

        // <yourObjectName>表示上传文件到OSS时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(content.getBytes()));
//        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, objectName, new ByteArrayInputStream(bytes));  // 上传byte数组

        // 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
        // ObjectMetadata metadata = new ObjectMetadata();
        // metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
        // metadata.setObjectAcl(CannedAccessControlList.Private);
        // putObjectRequest.setMetadata(metadata);

        // 上传字符串/Byte数组
        ossClient.putObject(putObjectRequest);

        // 关闭OSSClient
        ossClient.shutdown();
```

###### 1.1.2上传网络流

```java
// Endpoint以杭州为例，其它Region请按实际情况填写。
String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
String accessKeyId = "<yourAccessKeyId>";
String accessKeySecret = "<yourAccessKeySecret>";

// 创建OSSClient实例。
OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 上传网络流。
InputStream inputStream = new URL("https://www.aliyun.com/").openStream();
ossClient.putObject("<yourBucketName>", "<yourObjectName>", inputStream);

// 关闭OSSClient。
ossClient.shutdown();
```

###### 1.1.3上传文件流

```java
// Endpoint以杭州为例，其它Region请按实际情况填写。
String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
String accessKeyId = "<yourAccessKeyId>";
String accessKeySecret = "<yourAccessKeySecret>";

// 创建OSSClient实例。
OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 上传文件流。
InputStream inputStream = new FileInputStream("<yourlocalFile>");
ossClient.putObject("<yourBucketName>", "<yourObjectName>", inputStream);

// 关闭OSSClient。
ossClient.shutdown();
```

##### 1.2文件上传

以下代码用于上传本地文件

```java
// Endpoint以杭州为例，其它Region请按实际情况填写。
String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
// 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建RAM账号。
String accessKeyId = "<yourAccessKeyId>";
String accessKeySecret = "<yourAccessKeySecret>";

// 创建OSSClient实例。
OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

// 创建PutObjectRequest对象。
PutObjectRequest putObjectRequest = new PutObjectRequest("<yourBucketName>", "<yourObjectName>", new File("<yourLocalFile>"));

// 如果需要上传时设置存储类型与访问权限，请参考以下示例代码。
// ObjectMetadata metadata = new ObjectMetadata();
// metadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
// metadata.setObjectAcl(CannedAccessControlList.Private);
// putObjectRequest.setMetadata(metadata);

// 上传文件。
ossClient.putObject(putObjectRequest);

// 关闭OSSClient。
ossClient.shutdown();    
```

#### 2.表单上传

表单上传是使用**HTML表单形式上传文件**（Object）到指定存储空间（Bucket）中，文件最大不能超过5 GB。

```java
public class PostObjectSample {
    // 上传文件
    private String localFilePath = "<yourLocalFile>";
    // Endpoint以杭州为例，其它Region请按实际情况填写。
    private String endpoint = "http://oss-cn-hangzhou.aliyuncs.com";
    // 阿里云主账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM账号进行API访问或日常运维，请登录RAM控制台创建RAM账号。
    private String accessKeyId = "<yourAccessKeyId>";
    private String accessKeySecret = "<yourAccessKeySecret>";
    // 设置存储空间名称。
    private String bucketName = "<yourBucketName>";
    // 设置文件名称。
    private String objectName = "<yourObjectName>";
    /**
     * 表单上传。
     * @throws Exception
     */
    private void PostObject() throws Exception {
        // 在URL中添加存储空间名称，添加后URL如下：http://yourBucketName.oss-cn-hangzhou.aliyuncs.com。
        String urlStr = endpoint.replace("http://", "http://" + bucketName+ ".");
        // 设置表单Map。
        Map<String, String> formFields = new LinkedHashMap<String, String>();
        // 设置文件名称。
        formFields.put("key", this.objectName);
        // 设置Content-Disposition。
        formFields.put("Content-Disposition", "attachment;filename="
                + localFilePath);
        // 设置回调参数。
        Callback callback = new Callback();
        // 设置回调服务器地址，如http://oss-demo.aliyuncs.com:23450或http://127.0.0.1:9090。
        callback.setCallbackUrl("<yourCallbackServerUrl>");
        // 设置回调请求消息头中Host的值，如oss-cn-hangzhou.aliyuncs.com。
        callback.setCallbackHost("<yourCallbackServerHost>");
        // 设置发起回调时请求body的值。
        callback.setCallbackBody("{\\\"mimeType\\\":${mimeType},\\\"size\\\":${size}}");
        // 设置发起回调请求的Content-Type。
        callback.setCalbackBodyType(CalbackBodyType.JSON);
        // 设置发起回调请求的自定义参数，由Key和Value组成，Key必须以x:开始，且必须小写。
        callback.addCallbackVar("x:var1", "value1");
        callback.addCallbackVar("x:var2", "value2");
        // 在表单Map中设置回调参数。
        setCallBack(formFields, callback);
        // 设置OSSAccessKeyId。
        formFields.put("OSSAccessKeyId", accessKeyId);
        String policy = "{\"expiration\": \"2120-01-01T12:00:00.000Z\",\"conditions\": [[\"content-length-range\", 0, 104857600]]}";
        String encodePolicy = new String(Base64.encodeBase64(policy.getBytes()));
        // 设置policy。
        formFields.put("policy", encodePolicy);
        // 生成签名。
        String signaturecom = com.aliyun.oss.common.auth.ServiceSignature.create().computeSignature(accessKeySecret, encodePolicy);
        // 设置签名。
        formFields.put("Signature", signaturecom);
        String ret = formUpload(urlStr, formFields, localFilePath);
        System.out.println("Post Object [" + this.objectName + "] to bucket [" + bucketName + "]");
        System.out.println("post reponse:" + ret);
    }
    private static String formUpload(String urlStr, Map<String, String> formFields, String localFile)
            throws Exception {
        String res = "";
        HttpURLConnection conn = null;
        String boundary = "9431149156168";
        try {
            URL url = new URL(urlStr);
            conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.setReadTimeout(30000);
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("User-Agent", 
                    "Mozilla/5.0 (Windows; U; Windows NT 6.1; zh-CN; rv:1.9.2.6)");
            // 设置MD5值。MD5值由整个body计算得出。
            conn.setRequestProperty("Content-MD5", "<yourContentMD5>");
            conn.setRequestProperty("Content-Type",
                    "multipart/form-data; boundary=" + boundary);
            OutputStream out = new DataOutputStream(conn.getOutputStream());
            // 遍历读取表单Map中的数据，将数据写入到输出流中。
            if (formFields != null) {
                StringBuffer strBuf = new StringBuffer();
                Iterator<Entry<String, String>> iter = formFields.entrySet().iterator();
                int i = 0;
                while (iter.hasNext()) {
                    Entry<String, String> entry = iter.next();
                    String inputName = entry.getKey();
                    String inputValue = entry.getValue();
                    if (inputValue == null) {
                        continue;
                    }
                    if (i == 0) {
                        strBuf.append("--").append(boundary).append("\r\n");
                        strBuf.append("Content-Disposition: form-data; name=\""
                                + inputName + "\"\r\n\r\n");
                        strBuf.append(inputValue);
                    } else {
                        strBuf.append("\r\n").append("--").append(boundary).append("\r\n");
                        strBuf.append("Content-Disposition: form-data; name=\""
                                + inputName + "\"\r\n\r\n");
                        strBuf.append(inputValue);
                    }
                    i++;
                }
                out.write(strBuf.toString().getBytes());
            }
            // 读取文件信息，将要上传的文件写入到输出流中。
            File file = new File(localFile);
            String filename = file.getName();
            String contentType = new MimetypesFileTypeMap().getContentType(file);
            if (contentType == null || contentType.equals("")) {
                contentType = "application/octet-stream";
            }
            StringBuffer strBuf = new StringBuffer();
            strBuf.append("\r\n").append("--").append(boundary)
                    .append("\r\n");
            strBuf.append("Content-Disposition: form-data; name=\"file\"; "
                    + "filename=\"" + filename + "\"\r\n");
            strBuf.append("Content-Type: " + contentType + "\r\n\r\n");
            out.write(strBuf.toString().getBytes());
            DataInputStream in = new DataInputStream(new FileInputStream(file));
            int bytes = 0;
            byte[] bufferOut = new byte[1024];
            while ((bytes = in.read(bufferOut)) != -1) {
                out.write(bufferOut, 0, bytes);
            }
            in.close();
            byte[] endData = ("\r\n--" + boundary + "--\r\n").getBytes();
            out.write(endData);
            out.flush();
            out.close();
            // 读取返回数据。
            strBuf = new StringBuffer();
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line = null;
            while ((line = reader.readLine()) != null) {
                strBuf.append(line).append("\n");
            }
            res = strBuf.toString();
            reader.close();
            reader = null;
        } catch (Exception e) {
            System.err.println("Send post request exception: " + e);
            throw e;
        } finally {
            if (conn != null) {
                conn.disconnect();
                conn = null;
            }
        }
        return res;
    }
     private static void setCallBack(Map<String, String> formFields, Callback callback) {
        if (callback != null) {
            String jsonCb = OSSUtils.jsonizeCallback(callback);
            String base64Cb = BinaryUtil.toBase64String(jsonCb.getBytes());
            formFields.put("callback", base64Cb);
            if (callback.hasCallbackVar()) {
                Map<String, String> varMap = callback.getCallbackVar();
                for (Entry<String, String> entry : varMap.entrySet()) {
                    formFields.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        PostObjectSample ossPostObject = new PostObjectSample();
        ossPostObject.PostObject();
    }
}
```

#### 3.追加上传

#### 4.断点续传上传

#### 5.分片上传





## 注意点

1、如果您在上传大量文件时，在命名上使用了顺序前缀（如时间戳或字母顺序），可能会出现大量文件索引集中存储于存储空间中的某个特定分区的情况。此时如果您的请求次数过多，会导致请求速率下降。出现这种问题时，建议您为Object的名称增加随机前缀

https://help.aliyun.com/document_detail/64945.html?spm=a2c4g.11186623.2.29.71fc718bPVrqt3#concept-xtt-pln-vdb

2、





## Jasypt加解密：

本项目使用Jasypt对访问秘钥进行加密

![image-20201106153921850](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201106153921850.png)















