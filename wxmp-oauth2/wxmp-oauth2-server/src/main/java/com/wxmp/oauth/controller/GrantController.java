package com.wxmp.oauth.controller;

import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author zhaohg
 * @date 2019/06/21.
 */
@Controller
@SessionAttributes({"authorizationRequest"})// 必须配置
public class GrantController {
    
    @RequestMapping("/oauth/confirm_access")
    public ModelAndView getAccessConfirmation(Map<String, Object> model, HttpServletRequest request) throws Exception {
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");
        ModelAndView view = new ModelAndView("grant");
        view.addObject("clientId", authorizationRequest.getClientId());
        view.addObject("scopes", authorizationRequest.getScope());
        
        return view;
    }
    
    @RequestMapping({"/oauth/error"})
    public ModelAndView handleError(Map<String, Object> model, HttpServletRequest request) {
        Object error = request.getAttribute("error");
        String errorMsg;
        if (error instanceof OAuth2Exception) {
            OAuth2Exception oauthError = (OAuth2Exception) error;
            errorMsg = HtmlUtils.htmlEscape(oauthError.getSummary());
        } else {
            errorMsg = "Unknown error";
        }
        ModelAndView view = new ModelAndView("error");
        view.addObject("errorMsg", errorMsg);
        return view;
    }
}