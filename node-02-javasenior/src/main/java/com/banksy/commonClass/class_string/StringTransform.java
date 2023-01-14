package com.banksy.commonClass.class_string;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * String类与其他结构之间的转换
 * @Author banksy
 * @Data 2022/9/12 7:14 PM
 * @Version 1.0
 **/
public class StringTransform {

    /**
     String与基本数据类型、包装类之间的转换
     String-->基本数据类型、包装类；调用包装类的静态方法：parseXxx(str)
     基本数据类型、包装类-->String：调用String重载valueOf(xxx)
     */
    @Test
    public void test1(){
        String str1 = "123";
        int num = Integer.parseInt(str1);//String-->基本数据类型、包装类
        System.out.println(num);
        String str2 = String.valueOf(num);//基本数据类型、包装类-->String
        String str3 = num + "";
        System.out.println(str2);
        System.out.println(str1 == str3);
    }

    /**
     * String与char[]之间的转换
     * String --> char[]：调用String的toCharArray()
     * char[] --> String：调用String的构造器
     */
    @Test
    public void test2(){
        String str1 = "abc123";
        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);
        }

        char[] arr = new char[]{'h','e','l','l','o'};
        String str2 = new String(arr);
        System.out.println(str2);
    }

    /**
     * String与byte[]之间的转换
     * String --> byte[]：调用String的getBytes()
     * byte[] --> String：调用String的构造器
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123中国";
        byte[] bytes = str1.getBytes(StandardCharsets.UTF_8);
        System.out.println(Arrays.toString(bytes));

        String str2 = new String(bytes, "UTF-8");
        System.out.println(str2);
    }
}