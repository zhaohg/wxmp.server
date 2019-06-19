package com.wxmp.user.service;


import com.wxmp.user.entity.SysRole;

import java.util.List;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
public interface RoleService {
    List<SysRole> getRoleByUserId(Integer userId);
}
