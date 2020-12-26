package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.repository.ProductCategoryRepository;
import com.imooc.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.service.impl
 * @author: Candy520
 * @date: 2019/5/29 21:22
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryType) {
        return repository.findByCategoryTypeIn(categoryType);
    }
}
