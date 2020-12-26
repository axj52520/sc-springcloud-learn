package com.imooc.order.repository;

import com.imooc.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.repository
 * @author: Candy520
 * @date: 2019/5/30 9:34
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String> {
}
