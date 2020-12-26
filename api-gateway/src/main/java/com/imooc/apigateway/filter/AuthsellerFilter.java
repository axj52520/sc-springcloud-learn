package com.imooc.apigateway.filter;

import com.imooc.common.constant.RedisConstant;
import com.imooc.common.util.CookieUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/*
 * Copyright is owned by YONYOU.
 * 权限拦截(区分卖家和买家)
 * @Package: com.imooc.apigateway.filter
 * @author: Candy520
 * @date: 2019/5/31 16:18
 */
@Component
public class AuthsellerFilter extends ZuulFilter {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
    * 越小的越靠前
    * @returnType: int
    * @params: []
    * @author Candy520
    * @date 2019/5/31 16:20
    */
    @Override
    public int filterOrder() {
        return PRE_DECORATION_FILTER_ORDER -1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        if("/order/order/finish".equals(request.getRequestURI())){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Object run() throws ZuulException {
        // 具体实现的逻辑
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        //区分买家买家 分别新建买家和卖家的过滤器
        // TODO 注意：因为通过gateway 路径上需要拼接服务的servceId
        Cookie cookie=CookieUtil.get(request, "token");
        if(null == cookie
                || StringUtils.isEmpty(cookie.getValue())
                || StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))) {
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
