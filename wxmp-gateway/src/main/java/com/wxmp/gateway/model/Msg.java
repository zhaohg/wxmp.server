package com.wxmp.gateway.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * @author zhaohg
 * @date 2019/06/19.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Msg<T> implements Serializable {
    private static final long    serialVersionUID = -1177183613782210351L;
    private              Integer code;
    private              String  msg;
    private              T       data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
