package com.wxmp.oauth.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wxmp.oauth.response.BaseResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhaohg
 * @date 2019/07/5 16:34
 */
public class HttpUtils {
    
    public static void writerError(BaseResponse bs, HttpServletResponse response) throws IOException {
        response.setContentType("application/json,charset=utf-8");
        response.setStatus(bs.getStatus());
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(response.getOutputStream(), bs);
    }
    
}
