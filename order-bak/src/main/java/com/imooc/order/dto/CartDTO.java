package com.imooc.order.dto;

import lombok.Data;

/*
 * Copyright is owned by YONYOU.
 * 购物车
 * @Package: com.yonyou.wechatsell.product.dto
 * @author: Candy520
 * @date: 2019/5/20 14:02
 */
@Data
public class CartDTO {

    // 商品id
    private String productId;
    // 商品数量
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId=productId;
        this.productQuantity=productQuantity;
    }
}
