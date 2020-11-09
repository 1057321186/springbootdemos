package com.jasypt.jasypt.controller;


import com.jasypt.jasypt.config.PasswordConfig;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class LoginController {

    @Resource
    PasswordConfig passwordConfig;


    @PostMapping("/login")
    public void login(){
        System.out.println("解密后的账号:" + passwordConfig.getAccount());
        System.out.println("解密后的密码:" + passwordConfig.getPassword());
        System.out.println("盐值:" + passwordConfig.getSalt());
    }

}
