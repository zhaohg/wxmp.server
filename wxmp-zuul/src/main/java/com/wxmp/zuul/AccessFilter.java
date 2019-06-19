package com.wxmp.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhaohg
 * @date 2019/06/18.
 */
@Slf4j
public class AccessFilter extends ZuulFilter {
    /**
     * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
     * pre：可以在请求被路由之前调用
     * routing：在路由请求时候被调用
     * post：在routing和error过滤器之后被调用
     * error：处理请求时发生错误时被调用
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }
    
    /**
     * 通过int值来定义过滤器的执行顺序
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }
    
    /**
     * 返回一个boolean类型来判断该过滤器是否要执行
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }
    
    /**
     * 过滤器的具体逻辑。这里简单的进行了判断是否存在accessToken这个参数
     * @return
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("accessToken");
        if (accessToken == null) {
            log.warn("access token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        log.info("access token ok");
        return null;
    }
    //最后让这个类生成相应的实例，让其工作起来。
    //@Bean
    //public AccessFilter accessFilter() {
    //	return new AccessFilter();
    //}
    //这样，我们只有访问带有accessToken的参数才可以正确的访问到服务，实现了简单的权限控制。
    //如：http://localhost:5555/service-A/add?a=1&b=2&accessToken=token
}
