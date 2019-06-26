package com.wxmp.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
