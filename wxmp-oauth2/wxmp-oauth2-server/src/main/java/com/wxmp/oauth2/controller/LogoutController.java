package com.wxmp.oauth2.controller;

import com.wxmp.common.util.StatusCode;
import com.wxmp.common.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@RestController
public class LogoutController {
    
    @Autowired
    private ConsumerTokenServices consumerTokenServices;
    
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
