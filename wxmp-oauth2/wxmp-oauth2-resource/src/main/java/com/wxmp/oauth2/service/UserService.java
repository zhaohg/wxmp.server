package com.wxmp.oauth2.service;


import com.wxmp.oauth2.service.impl.UserServiceImpl;
import com.wxmp.common.vo.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@FeignClient(name = "user", fallback = UserServiceImpl.class)
public interface UserService {
    @GetMapping("user/findByUsername/{username}")
    Result findByUsername(@PathVariable("username") String username);
}
