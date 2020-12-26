package com.imooc.product.service.impl;

import com.imooc.common.enums.ResultEnum;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.exception.ProductException;
import com.imooc.product.repository.ProductInfoRepository;
import com.imooc.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.service.impl
 * @author: Candy520
 * @date: 2019/5/29 21:13
 */
@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository repository;

    @Override
    public List<ProductInfo> findUpAll() {
        return repository.findByProductStatus(ProductStatusEnum.UP.getStatus());
    }

    @Override
    public List<ProductInfo> findList(List<String> productId) {
        return repository.findByProductIdIn(productId);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO: cartDTOList){
            //判断库存是否足够
            Optional<ProductInfo> productInfoOptional = repository.findById(cartDTO.getProductId());
            if(!productInfoOptional.isPresent()){
                log.error("【商品查询】商品不存在");
                throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            ProductInfo productInfo = productInfoOptional.get();
            Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
            if(result < 0){
                throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
            }

            productInfo.setProductStock(result);
            repository.save(productInfo);
        }
    }

    @Override
    public void increaseStock(List<CartDTO> cartDTOList) {

    }
}

