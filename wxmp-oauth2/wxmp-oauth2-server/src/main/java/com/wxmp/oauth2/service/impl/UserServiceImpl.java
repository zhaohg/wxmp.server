package com.wxmp.oauth2.service.impl;

import com.wxmp.oauth2.service.UserService;
import com.wxmp.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public Result findByUsername(String username) {
        log.info("调用{}失败", "findByUsername");
        return Result.failure(100, "调用findByUsername接口失败");
    }
}
