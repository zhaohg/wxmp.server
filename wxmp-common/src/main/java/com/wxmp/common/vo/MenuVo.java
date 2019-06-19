package com.wxmp.common.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MenuVo {
    private Integer id;
    private String  code;
    private String  pCode;
    private String  pId;
    private String  name;
    private String  url;
    private Integer isMenu;
    private Integer level;
    private Integer sort;
    private Integer status;
    private String  icon;
    private Date    createTime;
    private Date    updateTime;
}
