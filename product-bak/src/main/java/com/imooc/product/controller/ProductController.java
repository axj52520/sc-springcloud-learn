package com.imooc.product.controller;

import com.imooc.common.util.ResultVOUtil;
import com.imooc.common.vo.ResultVO;
import com.imooc.product.dto.CartDTO;
import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.service.CategoryService;
import com.imooc.product.service.ProductService;
import com.imooc.product.vo.ProductInfoVO;
import com.imooc.product.vo.ProductVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.controller
 * @author: Candy520
 * @date: 2019/5/29 18:56
 */
@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    /**
    *1、查询所有在架的商品
     * 2、获取类目type列表
     * 3、查询类目
     * 4、构造数据
    * @returnType: void
    * @params: []
    * @author Candy520
    * @date 2019/5/29 19:26
    */
    @GetMapping("/list")
    public ResultVO list(){
        //1.查询所有在架的商品
        List<ProductInfo> productInfoList = productService.findUpAll();
        //2.查询所有类目
        List<Integer> categoryType = productInfoList.stream()
                .map(ProductInfo::getCategoryType)
                .collect(Collectors.toList());

        //3.从数据库查询类目
        List<ProductCategory> productCategoryList = categoryService.findByCategoryTypeIn(categoryType);
        //4.构造数据
        // 3.1首先遍历类目
        List<ProductVO> productVOList = new ArrayList<>();
        for (ProductCategory productCategory:productCategoryList) {
            ProductVO productVO = new ProductVO();
            productVO.setCategoryName(productCategory.getCategoryName());
            productVO.setCategoryType(productCategory.getCategoryType());
            List<ProductInfoVO> productInfoVOList = new ArrayList<>();
            for (ProductInfo productInfo:productInfoList) {
                if(productInfo.getCategoryType().equals(productCategory.getCategoryType())){
                    ProductInfoVO productInfoVO = new ProductInfoVO();
                    // Spring提供的一个工具类 将一个对象的属性值 copy到另外一个对象里
                    BeanUtils.copyProperties(productInfo,productInfoVO);
                    productInfoVOList.add(productInfoVO);
                }
            }
            productVO.setProductInfoVOList(productInfoVOList);
            productVOList.add(productVO);
        }
        return ResultVOUtil.success(productVOList);
    }

    /**
    * 获取商品列表（为订单服务提供）
    * @returnType: java.util.List<com.imooc.product.dataobject.ProductInfo>
    * @params: [productIdList]
    * @author Candy520
    * @date 2019/5/30 11:47
    */
    @PostMapping("/listForOrder")
    public List<ProductInfo> listForOrder(@RequestBody List<String> productIdList){
        return productService.findList(productIdList);
    }

    @PostMapping("/decreaseStock")
    public void decreaseStock(@RequestBody List<CartDTO> cartDTOList){
        productService.decreaseStock(cartDTOList);
    }
}
