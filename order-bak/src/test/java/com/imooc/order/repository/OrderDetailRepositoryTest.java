package com.imooc.order.repository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.dataobject.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderDetailRepositoryTest extends OrderApplicationTests {

    @Autowired
    private OrderDetailRepository repository;

    @Test
    public void testSave(){

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setDetailId("1521455");
        orderDetail.setOrderId("123456");
        orderDetail.setProductId("123456");
        orderDetail.setProductName("皮蛋瘦肉粥");
        orderDetail.setProductPrice(new BigDecimal("3.8"));
        orderDetail.setProductQuantity(2);
        orderDetail.setProductIcon("https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=109353495,3394727874&fm=27&gp=0.jpg");
        OrderDetail result = repository.save(orderDetail);
        Assert.assertTrue(null != result);
    }
}