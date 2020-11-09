package com.jasypt.jasypt.config;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

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
