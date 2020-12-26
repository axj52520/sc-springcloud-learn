package com.imooc.product.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

/*
 * Copyright is owned by YONYOU.
 * 类目
 * @Package: com.yonyou.wechatsell.product.dataobject
 * @author: Candy520
 * @date: 2019/5/19 15:00
 */
@Entity
@DynamicUpdate
@Data
public class ProductCategory {

    // 类目id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryId;

    // 类目名称
    private String categoryName;

    // 类目编号
    private Integer categoryType;

    private Date createTime;

    private Date updateTime;

    public ProductCategory() {
    }

    public ProductCategory(String categoryName, Integer categoryType) {
        this.categoryName=categoryName;
        this.categoryType=categoryType;
    }
}
