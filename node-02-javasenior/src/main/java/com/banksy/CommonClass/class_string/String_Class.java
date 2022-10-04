package com.banksy.CommonClass.class_string;

import org.junit.Test;

/**
 * String的使用
 *
 * @Author banksy
 * @Data 2022/9/8 9:16 PM
 * @Version 1.0
 **/
public class String_Class {

    /**
     String：字符集，使用一对""引起来表示
     1.String声明为final的，不可被集成
     2.String实现了Serializable接口【可序列化接口】，表示字符串是支持序列化的。
           实现了Comparable接口：可以比较大小。
     3.String内部定义了final char[] value用于存储字符串数据
     4.String代表不可变的字符序列。简称：不可变性。
            体现：1.[s1==s2]  当字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有的value进行赋值
                 2.[s3]      当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
                 3.[s4/s5]   当调用String的replace()方法修改指定字符或字符串时，也需要重新指定内存区域赋值，不能使用原有的value进行赋值
     5.通过字面量的方式（区别于new）给字符串赋值，此时的字符串值声明在字符串常量池中
     6.字符串常量池中是不会存储相同内容的字符串的
     */
    @Test
    public void test1(){
        String s1 = "abc";//String是一个类，不用new就可以赋值，称为字面量的定义方式
        String s2 = "abc";
        System.out.println(s1 == s2);//比较s1和s2的地址值，true

        s1 = "hello";
        System.out.println(s1);//hello
        System.out.println(s2);//abc
        System.out.println("****************************************************************");
        String s3 = "abc";
        s3 += "def";
        System.out.println(s3);//abcdef
        System.out.println("****************************************************************");
        String s4 = "abc";
        String s5 = s4.replace('a', 'm');
        System.out.println(s4);//abc
        System.out.println(s5);//mbc
    }

    /**
     String的实例化方式：
     方式一：通过字面量定义的方式
     方式二：通过new + 构造器的方式
     面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对？
     //两个：一个是堆空间中new结构，另一个是char[]对应的常量池中的数据"abc"
     在常量池中不会放两个相同的数据
     */
    @Test
    public void test2(){
        // 通过字面量定义的方式：此时s1和s2的数据javaEE声明在方法区中的字符常量池中
        String s1 = "javaEE";
        String s2 = "javaEE";
        //通过new + 构造器的方式：此时s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值，value对应字符常量池中的值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);//true
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4);//false
        System.out.println(s3 == s4);//false
        System.out.println("****************************************************************");
        //面试题：String s = new String("abc");方式创建对象，在内存中创建了几个对？
        // 两个：一个是堆空间中new结构，另一个是char[]对应的常量池中的数据"abc"
        //     在常量池中不会放两个相同的数据
        Person p1 = new Person("Tom", 12);
        Person p2 = new Person("Tom", 12);

        System.out.println(p1.name.equals(p2.name));//true
        System.out.println(p1.name == p2.name);//true
        p1.name = "Jerry";
        System.out.println(p2.name);//Tom
    }

    /**
     * 不同拼接的一些区别
     结论：1、常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量。
          2、只要其中有一个是变量，结果就在堆中
          3、若拼接的结果调用intern()方法，返回值就在常量池中
     **/
    @Test
    public void test3(){
        String s1 = "javaEE";//常量池
        String s2 = "hadoop";//常量池
        String s3 = "javaEEhadoop";//常量池
        String s4 = "javaEE" + "hadoop";//常量池
        String s5 = s1 + "hadoop";//堆空间
        String s6 = "javaEE" + s2;//堆空间
        String s7 = s1 + s2;//常量池
        System.out.println(s3 == s4);//true
        System.out.println(s3 == s5);//false
        System.out.println(s3 == s6);//false
        System.out.println(s5 == s6);//false

        System.out.println(s5 == s7);//false
        System.out.println(s6 == s7);//false

        System.out.println(s3 == s7);
        String s8 = s7.intern();//常量池
        System.out.println(s3 == s8);//true
    }






















}