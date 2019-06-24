package com.wxmp.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@EnableDiscoveryClient
//@EnableFeignClients
//@EnableHystrix
@SpringBootApplication
public class ResourceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(ResourceApplication.class, args);
    }
    
}
