package com.imooc.user.service;

import com.imooc.user.dataobject.UserInfo;
import com.imooc.user.service.impl.UserServiceImpl;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.user.service
 * @author: Candy520
 * @date: 2019/6/2 14:19
 */
public interface UserService {

    UserInfo findByOpenid(String openid);


}
