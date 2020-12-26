package com.imooc.order.exception;

import com.imooc.common.enums.ResultEnum;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.exception
 * @author: Candy520
 * @date: 2019/5/30 10:11
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message){
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
