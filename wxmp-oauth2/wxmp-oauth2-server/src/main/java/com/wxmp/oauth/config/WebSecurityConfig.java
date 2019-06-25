package com.wxmp.oauth.config;

import com.wxmp.oauth.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new Md5PasswordEncoder();//BCryptPasswordEncoder();
    }
    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
        auth.authenticationProvider(authenticationProvider());
    }
    
    private AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        authenticationProvider.setHideUserNotFoundExceptions(false);
        return authenticationProvider;
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/oauth/login", "/oauth/authorize")
                .and()
                .authorizeRequests()//定义哪些url需要被保护  哪些不需要保护
                //.antMatchers("/oauth/token" , "/oauth/check_token").permitAll()//定义这两个链接不需要登录可访问
                .antMatchers("/**").permitAll() //定义所有的都不需要登录  目前是测试需要
                .anyRequest().authenticated() //其他的都需要登录
                //.antMatchers("/sys/**").hasRole("admin") // /sys/**下的请求 需要有admin的角色
                .and()
                .formLogin()
                //.failureHandler(handler)
                .loginPage("/oauth/login")//.failureUrl("/oauth/login-error")
                .loginProcessingUrl("/oauth/authorize");//如果未登录则跳转登录的页面   这儿可以控制登录成功和登录失败跳转的页面
                //.usernameParameter("username").passwordParameter("password").permitAll()//定义号码与密码的parameter
                //.and()
                //.csrf().disable();//防止跨站请求  spring security中默认开启
        http.httpBasic().disable();
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**", "/js/**", "/fonts/**", "/icon/**", "/favicon.ico", "/images/**",
                "/swagger-ui.html/**", "/webjars/**", "/swagger-resources/**", "/v2/api-docs/**",
                "/swagger-resources/configuration/ui/**", "/swagger-resources/configuration/security/**"
        );
    }
    
}
