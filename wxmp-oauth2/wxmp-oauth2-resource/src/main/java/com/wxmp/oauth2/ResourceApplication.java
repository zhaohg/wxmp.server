package com.wxmp.oauth2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableHystrix
public class ResourceApplication {
    
    public static void main(String[] args) {
        //SpringApplication springApplication = new SpringApplication(OAuth2Application.class);
        //springApplication.setBannerMode(Banner.Mode.OFF);
        //springApplication.run(args);
        SpringApplication.run(ResourceApplication.class, args);
    }
    
}
