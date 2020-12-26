package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.repository
 * @author: Candy520
 * @date: 2019/5/29 19:07
 */
public interface ProductInfoRepository extends JpaRepository<ProductInfo,String> {
    List<ProductInfo> findByProductStatus(Integer productStatus);

    List<ProductInfo> findByProductIdIn(List<String> productId);
}
