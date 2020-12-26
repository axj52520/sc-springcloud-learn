package com.imooc.product.service;

import com.imooc.product.dataobject.ProductCategory;

import java.util.List;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.service
 * @author: Candy520
 * @date: 2019/5/29 21:21
 */
public interface CategoryService {

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType);
}
