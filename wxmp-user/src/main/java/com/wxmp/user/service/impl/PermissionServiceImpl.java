package com.wxmp.user.service.impl;

import com.wxmp.user.entity.SysMenu;
import com.wxmp.user.mapper.SysMenuMapper;
import com.wxmp.user.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private SysMenuMapper menuMapper;
    
    @Override
    public List<SysMenu> getPermissionsByRoleId(Integer roleId) {
        return menuMapper.getPermissionsByRoleId(roleId);
    }
}
