package com.wxmp.oauth.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author zhaohg
 * @date   2018/3/30 20:37
 *
 */
@Getter
@Setter
public class PageAndSortResponse extends BaseResponse {

    private Integer currentPage;
    private Integer pageSize;
    private long count;
    List items;

    protected PageAndSortResponse(){}

}
