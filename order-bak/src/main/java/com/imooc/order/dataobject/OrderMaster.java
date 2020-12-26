package com.imooc.order.dataobject;

import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.yonyou.wechatsell.product.dao.dataobject
 * @author: Candy520
 * @date: 2019/5/20 12:36
 */
@Data
@Entity
@DynamicUpdate
public class OrderMaster {

    @Id
    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;
    private Date createTime;
    private Date updateTime;

    //该注解忽略数据库对应关系 但是一般不建议这么干
//    @Transient
//    private List<OrderDetail> orderDetailList;

}
