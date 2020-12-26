package com.imooc.user.repository;

import com.imooc.user.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.user.repository
 * @author: Candy520
 * @date: 2019/6/2 14:18
 */
public interface UserInfoRepository extends JpaRepository<UserInfo,String> {

    UserInfo findByOpenid(String openid);
}
