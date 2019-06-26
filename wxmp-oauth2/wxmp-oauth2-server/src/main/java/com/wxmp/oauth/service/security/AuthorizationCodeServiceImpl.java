package com.wxmp.oauth.service.security;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

/**
 * 用来设置收取码服务的（即 AuthorizationCodeServices 的实例对象），主要用于 "authorization_code" 授权码类型模式
 * @author zhaohg
 * @date 2019/06/25.
 */
@Service
public class AuthorizationCodeServiceImpl extends JdbcAuthorizationCodeServices {
    
    public AuthorizationCodeServiceImpl(DataSource dataSource) {
        super(dataSource);
    }
    
    @Override
    public String createAuthorizationCode(OAuth2Authentication authentication) {
        return null;
    }

    @Override
    public OAuth2Authentication consumeAuthorizationCode(String code) {
        return null;
    }
}
