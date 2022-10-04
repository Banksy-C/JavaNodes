package com.banksy.CommonClass.class_string;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 * @Author banksy
 * @Data 2022/9/12 8:22 PM
 * @Version 1.0
 **/
public class StringBufferBuilder {
    /**
     String、StringBuffer、StringBuilder三者的异同
     String；不可变的字符序列、底层用char[]存储；
     StringBuffer：可变的字符序列、线程安全的、效率低；多线程问题使用；底层用char[]存储；
     StringBuilder：可变的字符序列、jdk5.0新增、线程不安全的、效率高；底层用char[]存储；

     内存解析【源码分析】：
     String str = new String();//char[] value = new char[0]
     String str1 = new String("abc");//char[] value = new char[]{'a','b','c'}//每次不一样都会新造一个

     StringBuffer sb1 = new StringBuffer();//char[] value = new chat[16];底层创建一个长度为16的数组
     sb1.append('a');//value[0] = 'a';
     sb1.append('b');//value[0] = 'b';

     StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char['abc'.length() + 16]
     //问题1：System.out.println(sb2.length());//3
     //问题2：扩容问题：如果要添加的数据底层数组撑不下了，那就需要扩容底层的数据。
            默认情况下，扩容为原来容量的2倍+2，同时将原有数组中的元素赋值到新的数组中
     开发中建议使用：StringBuffer(int capacity) 或 StringBuilder(int capacity)
     */
    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');//底层直接修改a为m，而不是创建一个新的；与String相比没有返回
        System.out.println(sb1);
    }

    /**
     * 三者的效率测试
     */
    @Test
    public void test2(){
        //出事设置
        long startTime = 0L;
        long endTime = 0L;
        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");
        //开始对比
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer的执行时间： " + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder的执行时间： " + (endTime - startTime));
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String的执行时间： " + (endTime - startTime));
    }

}