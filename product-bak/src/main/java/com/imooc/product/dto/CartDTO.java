package com.imooc.product.dto;

import lombok.Data;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.dto
 * @author: Candy520
 * @date: 2019/5/30 12:56
 */
@Data
public class CartDTO {
    private String productId;
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId=productId;
        this.productQuantity=productQuantity;
    }
}
