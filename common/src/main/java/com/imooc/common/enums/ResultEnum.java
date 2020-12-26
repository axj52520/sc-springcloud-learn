package com.imooc.common.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    SUCCESS(0,"成功"),
    ERROR(1,"请求失败"),
    PARAM_ERROR(2,"参数错误"),
    CART_EMPTY(3,"购物车为空"),
    PRODUCT_NOT_EXIST(4,"商品不存在"),
    PRODUCT_STOCK_ERROR(5,"库存有误"),
    LOGIN_FAIL(6,"登录失败"),
    ROLE_ERROR(7,"角色权限不存在"),
    ;
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code=code;
        this.message=message;
    }
}
