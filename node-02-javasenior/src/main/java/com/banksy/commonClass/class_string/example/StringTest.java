package com.banksy.commonClass.class_string.example;

/**
 * 面试题
 * 基本数据类型传递的是数据，引用数据类型传递的是地址
 * @Author banksy
 * @Data 2022/9/12 2:51 PM
 * @Version 1.0
 **/
public class StringTest {
    String str = new String("good");
    char[] ch = {'t', 'e', 's', 't'};

    public void change(String str, char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest ex = new StringTest();
        ex.change(ex.str, ex.ch);
        System.out.println(ex.str);//good
        System.out.println(ex.ch);//best
    }
}