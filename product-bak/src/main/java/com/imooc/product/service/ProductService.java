package com.imooc.product.service;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.service
 * @author: Candy520
 * @date: 2019/5/29 21:12
 */
public interface ProductService {

    List<ProductInfo> findUpAll();

    List<ProductInfo> findList(List<String> productId);

    void decreaseStock(List<CartDTO> cartDTOList);
    void increaseStock(List<CartDTO> cartDTOList);
}
