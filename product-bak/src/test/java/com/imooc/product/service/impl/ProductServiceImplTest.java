package com.imooc.product.service.impl;

import com.imooc.product.dto.CartDTO;
import com.imooc.product.ProductApplicationTests;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.service.ProductService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ProductServiceImplTest extends ProductApplicationTests {

    @Autowired
    private ProductService service;

    @Test
    public void findUpAll() {
        List<ProductInfo> productInfoList = service.findUpAll();
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findList() {
        List<ProductInfo> productInfoList = service.findList(Arrays.asList("345678","1558431457899642034"));
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void decreaseStock() throws Exception{

        CartDTO cartDTO = new CartDTO("345678",20);
        service.decreaseStock(Arrays.asList(cartDTO));
    }
}