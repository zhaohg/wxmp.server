package com.wxmp.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo implements Serializable {
    
    private Integer id;
    
    private String avatar;
    
    private String username;
    
    private String password;
    
    private String salt;
    
    private String name;
    
    private Date birthday;
    
    private Integer sex;
    
    private String email;
    
    private String phone;
    
    private Integer status;
    
    private Date createTime;
    
    private Date updateTime;
}
