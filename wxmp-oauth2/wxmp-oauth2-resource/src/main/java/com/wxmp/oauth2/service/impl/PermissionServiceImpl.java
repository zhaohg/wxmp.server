package com.wxmp.oauth2.service.impl;

import com.wxmp.oauth2.service.PermissionService;
import com.wxmp.common.vo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@Slf4j
@Service
public class PermissionServiceImpl implements PermissionService {
    @Override
    public Result getRolePermission(Integer roleId) {
        log.info("调用{}失败", "getRolePermission");
        return Result.failure(100, "调用getRolePermission失败");
    }
}
