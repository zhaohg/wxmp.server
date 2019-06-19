package com.wxmp.user.service;


import com.wxmp.user.entity.SysMenu;

import java.util.List;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
public interface PermissionService {
    List<SysMenu> getPermissionsByRoleId(Integer roleId);
}
