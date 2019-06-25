package com.wxmp.oauth.response;

import lombok.Data;

import java.util.List;

/**
 * @author zhaohg
 * @date  2018/8/6 15:56
 *
 **/
@Data
public class Items<T> {

    long count;
    List<T> items;

    public Items() {

    }

    public Items(long count, List<T> items) {
        this.count = count;
        this.items = items;
    }


}
