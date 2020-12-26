package com.imooc.order.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.yonyou.wechatsell.product.dataobject
 * @author: Candy520
 * @date: 2019/5/19 17:12
 */
@Data
@Entity
@DynamicUpdate
public class ProductInfo implements Serializable {

    private static final long serialVersionUID=2867752189539616502L;
    @Id
    private String productId;

    private String productName;

    private BigDecimal productPrice;

    private Integer productStock;

    private String productDescription;

    private String productIcon;

    private Integer productStatus;

    private Integer categoryType;

    private Date createTime;

    private Date updateTime;


}
