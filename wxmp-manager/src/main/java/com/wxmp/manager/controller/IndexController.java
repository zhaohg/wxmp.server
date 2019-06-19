package com.wxmp.manager.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@RestController
@RequestMapping("/")
@Api(value = "manager", tags = {"管理后台"})
public class IndexController {
    
    @GetMapping(value = "/index")
    public void index() {
        //return detailService.operateDetail(submit);
    }
}
