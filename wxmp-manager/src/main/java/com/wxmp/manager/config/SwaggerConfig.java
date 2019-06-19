package com.wxmp.manager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaohg
 * @date 2019/06/18.
 */
@Configuration
@ComponentScan(basePackages = {"com.wxmp.manager.controller"})
@EnableSwagger2
public class SwaggerConfig {
    
    @Bean
    public Docket createRestApi() {
        ParameterBuilder tokenPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<>();
        tokenPar.name("Authorization")
                .defaultValue("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6ImFkbWluIiwicGFzc3dvcmQiOiIxMjM0NTYiLCJleHAiOjE1NTU0MTI5NTAsIm5iZiI6MTU1NTMyNjU1MH0.RwAldUgYjlu8SOBlzDl_at78Vd5_P24p1JQbBhzjM9U")
                .description("令牌")
                .modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        pars.add(tokenPar.build());
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo()).tags(new Tag("manager", "manager"), getTags())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.wxmp.manager.controller"))
                .paths(PathSelectors.any())
                .build().globalOperationParameters(pars);
    }
    
    private Tag[] getTags() {
        Tag[] tags = {
                new Tag("book", "书相关的API")
        };
        return tags;
    }
    
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("manager")
                .description("manager")
                .termsOfServiceUrl("#")
                .contact(new Contact("赵宏钢", "zhaohg@dingtalk.com", "zhaohg@dingtalk.com"))
                .version("1.0")
                .build();
    }
}
