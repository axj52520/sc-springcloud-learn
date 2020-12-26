package com.imooc.order.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.imooc.order.dataobject.OrderDetail;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Copyright is owned by YONYOU.
 * // 值为null的将不返回给前端
 * //@JsonInclude(JsonInclude.Include.NON_NULL)
 * 如果想要字段为null 也要返回字段的话，则给该字段附一个初始值即可
 * @Package: com.yonyou.wechatsell.product.dto
 * @author: Candy520
 * @date: 2019/5/20 13:24
 */
@Data
public class OrderDTO {

    private String orderId;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private String buyerOpenid;
    private BigDecimal orderAmount;
    private Integer orderStatus;
    private Integer payStatus;

//    @JsonSerialize(using=Date2LongSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

//    @JsonSerialize(using=Date2LongSerializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    private List<OrderDetail> orderDetailList = new ArrayList<>();

//    @JsonIgnore
//    public OrderStatusEnum getOrderStatusEnum(){
//        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
//    }

//    @JsonIgnore
//    public  PayStatusEnum getPayStatusEnum(){
//        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
//    }

}
