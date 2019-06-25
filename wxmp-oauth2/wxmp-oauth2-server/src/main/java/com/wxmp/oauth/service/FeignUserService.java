package com.wxmp.oauth.service;


import com.wxmp.common.vo.Result;
import com.wxmp.oauth.service.impl.HystrixUserService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@FeignClient(name = "wxmp-user", fallback = HystrixUserService.class)
public interface FeignUserService {
    
    @GetMapping("/user/findByUsername/{username}")
    Result findByUsername(@PathVariable("username") String username);
    
    @GetMapping("/role/getRoleByUserId/{userId}")
    Result getRoleByUserId(@PathVariable("userId") Integer userId);
    
    @GetMapping("/permission/getRolePermission/{roleId}")
    Result getRolePermission(@PathVariable("roleId") Integer roleId);
}
