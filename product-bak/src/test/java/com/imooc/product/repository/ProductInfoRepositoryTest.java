package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRepositoryTest {


    @Autowired
    private ProductInfoRepository repository;
    @Test
    public void findByProductStatus() throws Exception{
        List<ProductInfo> productInfoList = repository.findByProductStatus(ProductStatusEnum.UP.getStatus());
        Assert.assertTrue(productInfoList.size() > 0);
    }

    @Test
    public void findByProductIdIn(){
        List<ProductInfo> productInfoList = repository.findByProductIdIn(Arrays.asList("345678","1558431457899642034"));
        Assert.assertTrue(productInfoList.size() > 0);
    }
}