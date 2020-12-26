package com.imooc.user.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.user.dataobject
 * @author: Candy520
 * @date: 2019/6/2 14:16
 */
@Data
@Entity
public class UserInfo {

    @Id
    private String id;

    private String username;

    private String password;

    private String openid;

    private Integer role;


}
