package com.imooc.order.controller;

import com.imooc.order.dto.CartDTO;
import com.imooc.order.dataobject.ProductInfo;
import com.imooc.order.feign.ProductClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

/*
 * Copyright is owned by YONYOU.
 * RestTemplate的三种使用方法
 * @Package: com.imooc.product.controller
 * @author: Candy520
 * @date: 2019/5/30 10:58
 */
@RestController
@Slf4j
public class ClientController {

//    @Autowired
//    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/getMsg")
    public String getMsg(){

        //第一种：直接使用restTemplate url写死
//        RestTemplate restTemplate = new RestTemplate();
//        String response = restTemplate.getForObject("http://localhost:8080/msg",String.class);

        //第二种：使用springcloud的loadbalancerClient通过应用名获取url
        ServiceInstance serviceInstance = loadBalancerClient.choose("PRODUCT");
        String url = String.format("http://%s:%s",serviceInstance.getHost(), serviceInstance.getPort()) + "/msg";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);

        //第三种：利用@loadbalanced可在restTemplate里使用名字
//        String response = restTemplate.getForObject("http://product/msg",String.class);

        return response;
    }

    @Autowired
    private ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg(){
        String response = productClient.productMsg();
        return response;
    }

    @GetMapping("/getProductList")
    public String getProductList(){
        List<ProductInfo> productInfoList = productClient.listForOrder(Arrays.asList("dsdad"));
        log.info("response={}",productInfoList);
        return "ok";
    }

    @GetMapping("/decreaseStock")
    public String decreaseStock(){
        productClient.decreaseStock(Arrays.asList(new CartDTO("345678",2)));
        return "ok";
    }

}
