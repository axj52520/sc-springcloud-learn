package com.imooc.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.controller
 * @author: Candy520
 * @date: 2019/5/30 11:01
 */
@RestController
public class ServiceController {

    @GetMapping("/msg")
    public String getMsg(){

        return "THIS IS PRODUCT SERVICE!";
    }
}
