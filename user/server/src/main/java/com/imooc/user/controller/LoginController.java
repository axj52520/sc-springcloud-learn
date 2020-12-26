package com.imooc.user.controller;

import com.imooc.common.constant.CookieConstant;
import com.imooc.common.constant.RedisConstant;
import com.imooc.common.enums.ResultEnum;
import com.imooc.common.util.CookieUtil;
import com.imooc.common.util.ResultVOUtil;
import com.imooc.common.vo.ResultVO;
import com.imooc.user.dataobject.UserInfo;
import com.imooc.user.enums.RoleEnum;
import com.imooc.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.user.controller
 * @author: Candy520
 * @date: 2019/6/2 14:23
 */
@RestController
@RequestMapping("/login")
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/buyer")
    public ResultVO buyerLogin(@RequestParam("openid") String openid,
                               HttpServletResponse response){

        //1.openid和数据库的进行匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if(null == userInfo){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2.判断角色
        if(RoleEnum.BUYER.getCode() != userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //3.设置cookie openid=abc
        CookieUtil.set(response, CookieConstant.OPENID,openid,CookieConstant.EXPIRE);

        return ResultVOUtil.success();
    }

    @GetMapping("/seller")
    public ResultVO sellerLogin(@RequestParam("openid") String openid,
                               HttpServletRequest request,
                               HttpServletResponse response){
        //判断是否已经登录
        Cookie cookie = CookieUtil.get(request,CookieConstant.TOKEN);
        if(null != cookie &&
                !StringUtils.isEmpty(redisTemplate.opsForValue().get(String.format(RedisConstant.TOKEN_TEMPLATE,cookie.getValue())))){
            return ResultVOUtil.success();
        }

        //1.openid和数据库的进行匹配
        UserInfo userInfo = userService.findByOpenid(openid);
        if(null == userInfo){
            return ResultVOUtil.error(ResultEnum.LOGIN_FAIL);
        }
        //2.判断角色
        if(RoleEnum.SELLER.getCode() != userInfo.getRole()){
            return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
        }
        //由于程序读取 会先从cookie中找缓存。所以建议先存redis
        // 如果redis保存失败了也就不会保存cookie了
        //3.设置到redis里token=abc
        String token =UUID.randomUUID().toString();
        Integer expire = CookieConstant.EXPIRE;
        redisTemplate.opsForValue().set(String.format(RedisConstant.TOKEN_TEMPLATE,token),
                openid,
                expire,
                TimeUnit.SECONDS);
        //4.设置cookie token=abc
        CookieUtil.set(response, CookieConstant.TOKEN,token,expire);

        return ResultVOUtil.success();
    }

}
