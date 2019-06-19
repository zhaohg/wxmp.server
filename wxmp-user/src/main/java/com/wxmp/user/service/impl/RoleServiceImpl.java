package com.wxmp.user.service.impl;

import com.wxmp.user.entity.SysRole;
import com.wxmp.user.mapper.SysRoleMapper;
import com.wxmp.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    private SysRoleMapper roleMapper;
    
    @Override
    public List<SysRole> getRoleByUserId(Integer userId) {
        return roleMapper.getRoleByUserId(userId);
    }
}
