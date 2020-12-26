package com.imooc.common.vo;

import com.imooc.common.enums.ResultEnum;
import lombok.Data;

/*
 * Copyright is owned by YONYOU.
 * HTTP返回的最外层对象
 * @Package: com.imooc.product.vo
 * @author: Candy520
 * @date: 2019/5/29 21:27
 */
@Data
public class ResultVO<T> {

    // 错误码
    private Integer code;

    // 提示信息
    private String msg;
    // 具体内容
    private T data;

    public ResultVO(Integer code, T data) {
        this.code = code;
        this.data=data;
    }

    public ResultVO() {
        this.code =ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMessage();
    }
}
