package com.imooc.product.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.vo
 * @author: Candy520
 * @date: 2019/5/29 21:30
 */
@Data
public class ProductInfoVO implements Serializable {
    private static final long serialVersionUID=-5416892791763161829L;

    @JsonProperty("id")
    private String productId;

    @JsonProperty("name")
    private String productName;

    @JsonProperty("price")
    private BigDecimal productPrice;

    @JsonProperty("description")
    private String productDescription;

    @JsonProperty("icon")
    private String productIcon;


}
