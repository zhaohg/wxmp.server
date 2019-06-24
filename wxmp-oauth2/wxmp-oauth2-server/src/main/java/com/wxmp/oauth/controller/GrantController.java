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
// 必须配置
@SessionAttributes("authorizationRequest")
public class GrantController {
    
    @RequestMapping("/oauth/confirm_access")
    public ModelAndView getAccessConfirmation(Map<String, Object> model,
                                              HttpServletRequest request) throws Exception {
    
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model
                .get("authorizationRequest");
    
        ModelAndView view = new ModelAndView("/grant");
        view.addObject("clientId", authorizationRequest.getClientId());
        view.addObject("scope", authorizationRequest.getScope().toArray()[0]);
    
        return view;
    }
    
    @RequestMapping({ "/oauth/error" })
    public String handleError(Map<String, Object> model, HttpServletRequest request) {
        Object error = request.getAttribute("error");
        String errorSummary;
        if (error instanceof OAuth2Exception) {
            OAuth2Exception oauthError = (OAuth2Exception) error;
            errorSummary = HtmlUtils.htmlEscape(oauthError.getSummary());
        } else {
            errorSummary = "Unknown error";
        }
        model.put("errorSummary", errorSummary);
        return "/error";
    }
}