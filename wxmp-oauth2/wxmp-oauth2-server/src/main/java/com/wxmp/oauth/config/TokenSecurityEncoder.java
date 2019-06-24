//package com.wxmp.oauth.config;
//
//import org.springframework.security.oauth2.common.OAuth2AccessToken;
//import org.springframework.security.oauth2.provider.OAuth2Authentication;
//import org.springframework.security.oauth2.provider.token.TokenEnhancer;
//
//import java.util.Collections;
//import java.util.Iterator;
//import java.util.List;
//
///**
// * @author zhaohg
// * @date 2019/06/21.
// */
//public class TokenSecurityEncoder implements TokenEnhancer {
//    private List<TokenEnhancer> delegates = Collections.emptyList();
//
//    public TokenSecurityEncoder() {
//    }
//
//    public void setTokenEnhancers(List<TokenEnhancer> delegates) {
//        this.delegates = delegates;
//    }
//
//    public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
//        OAuth2AccessToken result = accessToken;
//
//        TokenEnhancer enhancer;
//        for(Iterator var4 = this.delegates.iterator(); var4.hasNext(); result = enhancer.enhance(result, authentication)) {
//            enhancer = (TokenEnhancer)var4.next();
//        }
//
//        return result;
//    }
//}
