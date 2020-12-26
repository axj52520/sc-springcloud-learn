package com.imooc.apigateway.filter;

import com.google.common.util.concurrent.RateLimiter;
import com.imooc.apigateway.exception.RateLimiterException;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.SERVLET_DETECTION_FILTER_ORDER;

/*
 * Copyright is owned by YONYOU.
 * 限流拦截器
 * @Package: com.imooc.apigateway.filter
 * @author: Candy520
 * @date: 2019/6/1 13:52
 */
public class RateLimiterFilter extends ZuulFilter {

    // 谷歌的guava令牌桶的实现
    private static final RateLimiter RATE_LIMITER = RateLimiter.create(100);

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    //使用zuul提供的优先级最小的，我们要比这个还要小
    @Override
    public int filterOrder() {
        return SERVLET_DETECTION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        if (!RATE_LIMITER.tryAcquire()) {
            throw new RateLimiterException();
        }
        return null;
    }
}
