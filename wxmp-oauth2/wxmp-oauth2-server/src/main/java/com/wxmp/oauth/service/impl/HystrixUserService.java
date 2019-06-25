package com.wxmp.oauth.service.impl;

import com.wxmp.common.vo.Result;
import com.wxmp.oauth.service.FeignUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@Service
@Slf4j
public class HystrixUserService implements FeignUserService {
    @Override
    public Result findByUsername(String username) {
        log.error("调用{}失败", "findByUsername");
        return Result.failure(100, "调用findByUsername接口失败");
    }
    
    @Override
    public Result getRolePermission(Integer roleId) {
        log.error("调用{}失败", "getRolePermission");
        return Result.failure(100, "调用getRolePermission失败");
    }
    
    @Override
    public Result getRoleByUserId(Integer userId) {
        log.error("调用{}失败", "getRoleByUserId");
        return Result.failure(100, "调用getRoleByUserId失败");
    }
}
