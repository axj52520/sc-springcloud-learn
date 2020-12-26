package com.imooc.product.exception;

import com.imooc.common.enums.ResultEnum;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.exception
 * @author: Candy520
 * @date: 2019/5/30 13:00
 */
public class ProductException extends RuntimeException {
    private Integer code;
    public ProductException(Integer code,String message){
        super(message);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}
