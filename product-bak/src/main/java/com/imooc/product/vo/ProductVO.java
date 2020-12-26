package com.imooc.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.vo
 * @author: Candy520
 * @date: 2019/5/29 21:28
 */
@Data
public class ProductVO {

    @JsonProperty("name")
    private  String categoryName;

    @JsonProperty("type")
    private  Integer categoryType;

    @JsonProperty("foods")
    private List<ProductInfoVO> productInfoVOList;



}
