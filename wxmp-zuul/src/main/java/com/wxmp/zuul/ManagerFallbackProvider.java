package com.wxmp.zuul;

import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author zhaohg
 * @date 2019/06/18.
 */

@Component
public class ManagerFallbackProvider implements FallbackProvider {
    
    @Override
    public String getRoute() {
        return "api-a";
    }
    
    @Override
    public ClientHttpResponse fallbackResponse(String route, Throwable cause) {
        return new ClientHttpResponse() {
            
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.APPLICATION_JSON);
                return headers;
            }
            
            @Override
            public InputStream getBody() throws IOException {
                return new ByteArrayInputStream("fallback".getBytes());
            }
            
            @Override
            public String getStatusText() throws IOException {
                return "OK";
            }
            
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }
            
            @Override
            public int getRawStatusCode() throws IOException {
                return 200;
            }
            
            @Override
            public void close() {
            
            }
        };
    }
    
}