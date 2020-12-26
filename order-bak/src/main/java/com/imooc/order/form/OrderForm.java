package com.imooc.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.form
 * @author: Candy520
 * @date: 2019/5/30 10:07
 */
@Data
public class OrderForm {

    @NotEmpty(message="姓名必填")
    private String name;

    @NotEmpty(message="手机号必填")
    private String phone;

    @NotEmpty(message="openid必填")
    private String openid;

    @NotEmpty(message="地址必填")
    private String address;

    @NotEmpty(message="购物车不能为空")
    private String items;
}
