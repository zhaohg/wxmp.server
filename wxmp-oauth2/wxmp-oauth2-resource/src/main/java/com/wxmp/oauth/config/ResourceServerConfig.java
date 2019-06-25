package com.wxmp.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * <p>参看：https://github.com/spring-guides/tut-spring-security-and-angular-js/blob/master/oauth2-vanilla/README.adoc</p>
 * @author zhaohg
 * @date 2019/06/19.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    
    private static final String URL = "http://localhost:8500/oauth/check_token";
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                csrf().disable()
                //.authorizeRequests().anyRequest().authenticated()
                .authorizeRequests().antMatchers("/order/**").authenticated()
                .and()
                .httpBasic();
        
    }
    
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        RemoteTokenServices tokenService = new RemoteTokenServices();
        tokenService.setCheckTokenEndpointUrl(URL);
        tokenService.setClientId("webapp");
        tokenService.setClientSecret("123456");
        
        resources.tokenServices(tokenService);
        super.configure(resources);
    }
}
