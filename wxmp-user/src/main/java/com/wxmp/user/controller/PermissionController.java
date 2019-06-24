package com.wxmp.user.controller;

import com.wxmp.common.vo.Result;
import com.wxmp.user.entity.SysMenu;
import com.wxmp.user.service.PermissionService;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RestController
@RequestMapping("/permission")
public class PermissionController {
    
    @Autowired
    private PermissionService permissionService;
    
    @GetMapping("/getRolePermission/{roleId}")
    public Result getRolePermission(@PathVariable("roleId") Integer roleId) {
        List<SysMenu> menuList = permissionService.getPermissionsByRoleId(roleId);
        return Result.ok().setData(menuList);
    }
    
}
