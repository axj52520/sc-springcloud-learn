package com.imooc.common.util;

import java.util.Random;

/*
 * Copyright is owned by YONYOU.
 *
 * @Package: com.imooc.common.util
 * @author: Candy520
 * @date: 2019/5/30 9:48
 */
public class KeyUtil {

    /*
    * 生成为宜的主键
    * 格式： 时间+随机数
    * @returnType:
    * @params:
    * @author Candy520
    * @date 2019/5/30 10:02
    */
    public static synchronized String genUniqueKey(){
        Random random = new Random();
        Integer number = random.nextInt(9000000) + 1000000;
        return System.currentTimeMillis() + String.valueOf(number);
    }
}
