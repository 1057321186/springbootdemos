package com.jasypt.jasypt;

import com.jasypt.jasypt.config.PasswordConfig;
import org.jasypt.util.text.BasicTextEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class JasyptApplicationTests {

    @Resource
    PasswordConfig passwordConfig;


    @Test
    void contextLoads() {
        BasicTextEncryptor textEncryptor = new BasicTextEncryptor();

        String salt = passwordConfig.getSalt();
        System.out.println("加密的盐值=" + salt);
        //加密所需的salt(盐)
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

}
