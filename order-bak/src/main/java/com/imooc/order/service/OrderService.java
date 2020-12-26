package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.service.impl
 * @author: Candy520
 * @date: 2019/5/30 9:52
 */
public interface OrderService {

//    create(orderMaster,orderDetail);
    OrderDTO create(OrderDTO orderDTO);
}
