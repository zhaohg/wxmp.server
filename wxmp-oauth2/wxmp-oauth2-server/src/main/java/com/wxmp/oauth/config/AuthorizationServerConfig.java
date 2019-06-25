package com.wxmp.oauth.config;

import com.wxmp.oauth.error.MssWebResponseExceptionTranslator;
import com.wxmp.oauth.filter.AuthorizationFilter;
import com.wxmp.oauth.service.security.ClientDetailServiceImpl;
import com.wxmp.oauth.service.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.JdbcApprovalStore;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.code.JdbcAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private DataSource dataSource;
    
    @Autowired
    private UserDetailsServiceImpl          userDetailsService;//user
    //private UserDetailsService userDetailsService;
    //@Autowired
    //private AuthorizationCodeServiceImpl authorizationCodeService;//authorization
    @Autowired
    private ClientDetailServiceImpl         clientDetailsService;//client
    //private ClientDetailsService    clientDetailsService;
    
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    
    @Autowired
    private AuthorizationFilter authorizationFilter;
    
    //redis 管理access_token和refresh_token
    @Bean
    RedisTokenStore redisTokenStore() {
        return new RedisTokenStore(redisConnectionFactory);
    }
    
    //数据库管理access_token和refresh_token
//    @Bean
//    public JdbcTokenStore jdbcTokenStore(){
//        return new JdbcTokenStore(dataSource);
//    }
    
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.withClientDetails(clientDetails());
    }
    
    @Bean
    public ClientDetailsService clientDetails() {
        return new JdbcClientDetailsService(dataSource);
    }
    
    @Bean
    public WebResponseExceptionTranslator<OAuth2Exception> webResponseExceptionTranslator() {
        return new MssWebResponseExceptionTranslator();
    }
    
    // 数据库管理授权码
    @Bean
    public AuthorizationCodeServices authorizationCodeServices() {
        return new JdbcAuthorizationCodeServices(dataSource);
    }
    
    // 数据库管理授权信息
    @Bean
    public ApprovalStore approvalStore() {
        return new JdbcApprovalStore(dataSource);
    }
    
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);//开启密码授权类型
        endpoints.tokenStore(redisTokenStore());//配置token存储方式 一共有5种
        //endpoints.userDetailsService(userDetailsService);
        endpoints.setClientDetailsService(clientDetailsService);
        //endpoints.authorizationCodeServices(authorizationCodeService);
        endpoints.tokenServices(defaultTokenServices());
        endpoints.exceptionTranslator(webResponseExceptionTranslator());//自定义登录或者鉴权失败时的返回信息
        //endpoints.tokenEnhancer(tokenSecurityEncoder());
        endpoints.authorizationCodeServices(authorizationCodeServices());
        endpoints.approvalStore(approvalStore());
        // 用户信息查询服务
        endpoints.userDetailsService(userDetailsService);
        // 最后一个参数为替换之后页面的url
        //endpoints.pathMapping("/oauth/confirm_access", "/oauth/confirm_access");
    }
    
    //@Bean
    //public TokenEnhancer tokenSecurityEncoder() {
    //    return new TokenSecurityEncoder();
    //}
    
    /**
     * <p>注意，自定义TokenServices的时候，需要设置@Primary，否则报错，</p>
     * @return
     */
    @Primary
    @Bean
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setTokenStore(redisTokenStore());
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setClientDetailsService(clientDetails());
        //tokenServices.setTokenEnhancer(tokenSecurityEncoder());
        tokenServices.setAccessTokenValiditySeconds((int) TimeUnit.MINUTES.toSeconds(60 * 60 * 24)); // token有效期自定义设置，默认24小时
        tokenServices.setRefreshTokenValiditySeconds(60 * 60 * 24 * 7);//默认30天
        return tokenServices;
    }
    
    /**
     * 用来配置令牌端点(Token Endpoint)的安全约束.
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.allowFormAuthenticationForClients();        // 允许表单登录
        authorizationFilter.setClientDetailsService(clientDetailsService);        // 加载client的service
        //security.authenticationEntryPoint(authenticationEntryPoint);        // 自定义异常处理端口
        security.addTokenEndpointAuthenticationFilter(authorizationFilter);        // 客户端认证之前的过滤器
        
        security.tokenKeyAccess("permitAll()"); ///开启/oauth/token_key验证端口无权限访问
        security.checkTokenAccess("isAuthenticated()");// 开启/oauth/check_token验证端口认证权限访问
    }
}
