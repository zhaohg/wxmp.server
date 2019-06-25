package com.wxmp.oauth.controller;

import com.wxmp.common.util.StatusCode;
import com.wxmp.common.vo.Result;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.security.Principal;
import java.util.Map;

/**
 * 登录 注销
 * @author zhaohg
 * @date 2019/06/21.
 */
@Controller
@RequestMapping("/oauth")
public class LoginController {
    
    @RequestMapping("/login")
    public String loginPage(Map<String, String> model) {
        model.put("oauthLoginUrl", "/oauth/authorize");
        return "login";
    }
    //
    //@GetMapping("/login-error")
    //public ModelAndView loginError(HttpServletRequest request, Model model) {
    //    model.addAttribute("loginError", true);
    //    model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
    //    return new ModelAndView("login", "userModel", model);
    //}
    
    @Resource
    private ConsumerTokenServices consumerTokenServices;
    
    @GetMapping("/user")
    public Principal user(Principal user) {
        return user;
    }
    
    @DeleteMapping(value = "/logout")
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
