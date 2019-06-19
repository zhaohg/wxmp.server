package com.wxmp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

//@Configuration
//@EnableAutoConfiguration
@EnableDiscoveryClient //注册中心除 eureka 推荐使用
//@EnableEurekaClient//注册中心是 eureka 推荐使用
@EnableConfigServer
//一个@SpringbootApplication相当于@Configuration,@EnableAutoConfiguration和 @ComponentScan 并具有他们的默认属性值
@SpringBootApplication
public class ConfigApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }
    
}
