package com.wxmp.user.service.impl;

import com.wxmp.user.entity.SysUser;
import com.wxmp.user.mapper.SysUserMapper;
import com.wxmp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private SysUserMapper userMapper;
    
    @Override
    public SysUser findByUsername(String username) {
        SysUser user = new SysUser();
        user.setUsername(username);
        return userMapper.selectOne(user);
    }
}
