package com.hason.dtp.account.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * 账户 Web 系统
 *
 * @author Huanghs
 * @since 2.0
 * @date 2017/11/9
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class AccountWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountWebApplication.class, args);
    }

}
