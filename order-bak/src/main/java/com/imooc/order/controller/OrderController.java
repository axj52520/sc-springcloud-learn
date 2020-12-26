package com.imooc.order.controller;

import com.imooc.common.enums.ResultEnum;
import com.imooc.common.util.ResultVOUtil;
import com.imooc.common.vo.ResultVO;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.exception.OrderException;
import com.imooc.order.form.OrderForm;
import com.imooc.order.service.OrderService;
import com.imooc.order.util.OrderForm2OrderDTOConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.controller
 * @author: Candy520
 * @date: 2019/5/30 9:50
 */
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
    * 1.参数校验
     * 2.查询商品信息（调用商品服务）
     * 3.计算总价
     * 4.扣库存（调用商品服务）
     * 5.订单入库
    * @returnType: void
    * @params: []
    * @author Candy520
    * @date 2019/5/30 9:50
    */
    @PostMapping("/create")
    public ResultVO create(@Valid OrderForm orderForm,
                           BindingResult bindingResult){
        // 参数校验
        if(bindingResult.hasErrors()){
            log.error("【创建订单】 参数不正确，orderForm={}",orderForm);
            throw new OrderException(ResultEnum.PARAM_ERROR.getCode(),bindingResult.getFieldError().getDefaultMessage());
        }
        //参数转换orderForm -> orderDTO
        OrderDTO orderDTO =OrderForm2OrderDTOConverter.convert(orderForm);
        if(orderDTO.getOrderDetailList().size() == 0){
            log.error("【创建订单】购物车信息为空");
            throw new OrderException(ResultEnum.CART_EMPTY);
        }
        OrderDTO result = orderService.create(orderDTO);

        return ResultVOUtil.success(result);
    }
}
