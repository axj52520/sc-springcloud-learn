package com.imooc.common.util;

import com.imooc.common.enums.ResultEnum;
import com.imooc.common.vo.ResultVO;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.product.util
 * @author: Candy520
 * @date: 2019/5/29 21:59
 */
public class ResultVOUtil {

    public static ResultVO success(Object data){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(data);
        return resultVO;
    }

    public static ResultVO success(){
        ResultVO resultVO = new ResultVO();
        return resultVO;
    }

    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setMsg(resultEnum.getMessage());
        resultVO.setCode(resultEnum.getCode());
        return resultVO;
    }
}
