package com.wxmp.user.controller;


import com.wxmp.common.vo.Result;
import com.wxmp.user.entity.SysRole;
import com.wxmp.user.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@RestController
@RequestMapping("/role")
public class RoleController {
    
    @Autowired
    private RoleService roleService;
    
    @GetMapping("/getRoleByUserId/{userId}")
    public Result getRoleByUserId(@PathVariable("userId") Integer userId) {
        List<SysRole> roleList = roleService.getRoleByUserId(userId);
        return Result.ok().setData(roleList);
    }
    
}
