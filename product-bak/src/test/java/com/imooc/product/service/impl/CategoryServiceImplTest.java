package com.imooc.product.service.impl;

import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.repository.ProductCategoryRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class CategoryServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductCategoryRepository repository;

    @Test
    public void findByCategoryTypeIn() {
        List<ProductCategory> productCategoryList = repository.findByCategoryTypeIn(Arrays.asList(1,2));
        Assert.assertTrue(productCategoryList.size() > 0 );
    }
}