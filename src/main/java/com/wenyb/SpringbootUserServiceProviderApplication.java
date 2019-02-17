package com.wenyb;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//xml配置方式
//@ImportResource(locations = "classpath:provider.xml")
//API注解方式
@EnableDubbo(scanBasePackages = "com.wenyb")
@SpringBootApplication
public class SpringbootUserServiceProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootUserServiceProviderApplication.class, args);
    }

}

