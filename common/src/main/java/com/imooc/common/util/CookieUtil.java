package com.imooc.common.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.common.util
 * @author: Candy520
 * @date: 2019/6/2 14:44
 */
public class CookieUtil {

    /**
    * 设置cookie
    * @returnType: void
    * @params: [response, name, value, maxAge]
    * @author Candy520
    * @date 2019/6/2 14:46
    */
    public static void set(HttpServletResponse response,
                           String name,
                           String value,
                           int maxAge) {
        Cookie cookie = new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);

    }

    public static Cookie get(HttpServletRequest request, String token) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie: cookies) {
                if (token.equals(cookie.getName())) {
                    return cookie;
                }
            }
        }

        return null;
    }
}
