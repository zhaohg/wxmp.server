package com.wxmp.user.controller;


import com.wxmp.common.vo.Result;
import com.wxmp.user.entity.SysUser;
import com.wxmp.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @GetMapping("/findByUsername/{username}")
    public Result findByUsername(@PathVariable("username") String username) {
        SysUser user = userService.findByUsername(username);
        if (user == null) {
            return Result.failure(100, "用户不存在");
        }
        return Result.ok().setData(user);
    }
}
