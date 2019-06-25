package com.wxmp.oauth.service.security;

import com.alibaba.fastjson.JSONObject;
import com.wxmp.common.util.StatusCode;
import com.wxmp.common.vo.Result;
import com.wxmp.oauth.service.FeignClientService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zhaohg
 * @date 2019/06/25.
 */
@Service
public class ClientDetailServiceImpl implements ClientDetailsService {
    
    @Resource
    private FeignClientService clientService;
    
    @Override
    public ClientDetails loadClientByClientId(String clientId) {
        Result result = clientService.loadClientByClientId(clientId);
        if (result.getCode() != StatusCode.SUCCESS_CODE) {
            throw new UsernameNotFoundException("客户端:" + clientId + ", 不存在!");
        }
        
        JSONObject.toJSONString(result.getData());
        
        return null;
    }
    
}
