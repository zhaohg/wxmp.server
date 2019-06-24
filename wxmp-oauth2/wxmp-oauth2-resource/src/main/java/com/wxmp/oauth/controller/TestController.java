package com.wxmp.oauth.controller;

import com.wxmp.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/order")
@Slf4j
public class TestController {
    
    @RequestMapping(value = "/demo")
    public Result getDemo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        log.info("auth : {}", auth.toString());
        log.info("scope : {}", ((OAuth2Authentication) auth).getOAuth2Request().getScope().toString());
        return Result.ok();
    }
}
