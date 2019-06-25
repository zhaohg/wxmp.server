package com.wxmp.oauth.response;

import lombok.Data;

/**
 * @author zhaohg
 * @date   2018/3/30 20:37
 *
 */
@Data
public  class BaseResponse  {

    private int status;
    private String msg;

    protected BaseResponse() {
    }

    protected BaseResponse(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
