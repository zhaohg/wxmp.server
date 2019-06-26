package com.wxmp.oauth.controller;

import com.wxmp.common.util.StatusCode;
import com.wxmp.common.vo.Result;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;

/**
 * @author zhaohg
 * @date 2019/06/26.
 */
@RestController
@RequestMapping("/api")
public class UserController {
    
    @Resource
    private ConsumerTokenServices consumerTokenServices;
    
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    
    @DeleteMapping(value = "/exit")
    public Result revokeToken(String access_token) {
        Result msg = new Result();
        if (consumerTokenServices.revokeToken(access_token)) {
            msg.setCode(StatusCode.SUCCESS_CODE);
            msg.setMsg("注销成功");
        } else {
            msg.setCode(StatusCode.FAILURE_CODE);
            msg.setMsg("注销失败");
        }
        return msg;
    }
}
