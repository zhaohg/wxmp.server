package com.wxmp.user.service;


import com.wxmp.user.entity.SysUser;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
public interface UserService {
    SysUser findByUsername(String username);
}
