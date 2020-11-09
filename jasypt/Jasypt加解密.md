## SpringBoot整合Jasypt

### 1、引入依赖

```java
<!-- 引入jasypt -->
<dependency>
    <groupId>com.github.ulisesbocchio</groupId>
    <artifactId>jasypt-spring-boot-starter</artifactId>
    <version>2.1.1</version>
</dependency>
```

### 2、yml配置

```yaml
server:
  port: 1059
jasypt:
  encryptor:
    algorithm: PBEWithMD5AndDES
    # 自定义jasypt秘钥,加密时需要
    password: ${salt}
    string-output-type: base64
    property:
      prefix: ENC(
      suffix: )

```

秘钥数据源可以配置在VM options中 or 环境变量 or 明文(意义不大)

![image-20201109095643820](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201109095643820.png)

### 3、要加密参数的配置文件

```java
@Getter
@Setter
@Configuration
@PropertySource(value = {"classpath:password.properties"},encoding = "UTF-8")
public class PasswordConfig {

    @Value("${jasypt.account}")
    String account;

    @Value("${jasypt.password}")
    String password;

    @Value("${jasypt.salt}")
    String salt;
}
```

### 4、使用Jasypt 加解密

```java
@Test
void contextLoads() {
    BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

    String salt = passwordConfig.getSalt();
    System.out.println("加密的盐值=" + salt);
    //加密所需的salt(盐),我存放在VM options中的
    textEncryptor.setPassword(salt);

    //要加密的数据（数据库的用户名或密码）
    String account = textEncryptor.encrypt("admin");
    String password = textEncryptor.encrypt("123456");
    System.out.println("加密account:" + account);
    System.out.println("加密password:" + password);
    System.out.println("--------------------------------------");
    //解密
    String account1 = textEncryptor.decrypt(account);
    String password1 = textEncryptor.decrypt(password);
    System.out.println("解密account:" + account1);
    System.out.println("解密password:" + password1);

}
```

输出结果:

```
加密的盐值=salt
加密account:DWQMtcorseu/IF4rZ71b+Q==
加密password:CeHPRvnonruLKBJQzQVHug==
--------------------------------------

解密account:admin
解密password:123456
```

获取输出结果中的密文，保存在配置文件中并将输出的密文用ENC()括起来

```
# 要加密的参数，将输出的密文用ENC()括起来
jasypt.account=ENC(LIXIb1jdZVKVNHXzi9I5PQ==)
jasypt.password=ENC(DP8acsqEonaCyo26v/7mUg==)
# 盐值
jasypt.salt=${salt}
```



### 5、使用效果：

![image-20201109104249365](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20201109104249365.png)