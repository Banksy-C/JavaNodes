package com.banksy.commonClass.class_date;

import org.junit.Test;

/**
 * @Author banksy
 * @Data 2022/9/12 10:08 PM
 * @Version 1.0
 **/
public class DataTime {
    /**
     * 1. java.lang.System类
     */
    @Test
    public void test1(){
        //返回当前时间与1970年1月1日0时0分0秒之间以毫秒为单位的时间差。
        long time = System.currentTimeMillis();
        //俗称，时间戳
        System.out.println(time);
    }

    /**
     * 2. java.util.Date类
     */
    @Test
    public void test2(){

    }

    /**
     * 3. java.text.SimpleDateFormat类
     */

    /**
     * 4. java.util.Calendar(日历)类
     */
}