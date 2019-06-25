package com.wxmp.oauth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author zhaohg
 * @date 2019/06/21.
 */
@Controller
public class LoginController {
    
    @RequestMapping("/oauth/login")
    public String loginPage(Map<String, String> model) {
        model.put("oauthLoginUrl", "/oauth/authorize");
        return "login";
    }
    
    @GetMapping("/oauth/login-error")
    public ModelAndView loginError(HttpServletRequest request, Model model) {
        model.addAttribute("loginError", true);
        model.addAttribute("errorMsg", "登陆失败，账号或者密码错误！");
        return new ModelAndView("login", "userModel", model);
    }
}
