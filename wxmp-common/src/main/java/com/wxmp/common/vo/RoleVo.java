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
public class RoleVo implements Serializable {
    private Integer id;
    
    private String name;
    
    private String value;
    
    private String tips;
    
    private Date createTime;
    
    private Date updateTime;
    
    private Integer status;
}
