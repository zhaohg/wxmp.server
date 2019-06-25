package com.wxmp.oauth.service;

import com.wxmp.common.vo.Result;
import com.wxmp.oauth.service.impl.HystrixUserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhaohg
 * @date 2019/06/25.
 */
@FeignClient(name = "wxmp-user", fallback = HystrixUserService.class)
public interface FeignClientService {
    
    @GetMapping("/client/findByClientId/{clientId}")
    Result loadClientByClientId(@PathVariable("clientId") String clientId);
    
}
