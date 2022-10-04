package com.banksy.Generics.GenericsExtends;

import org.junit.Test;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型在继承方面的体现
 *
 * @Author banksy
 * @Data 2022/9/21 11:07 PM
 * @Version 1.0
 **/
public class GenericsTest {
    /**
     * 泛型在继承方面的体现
     * 虽然类A是类B的父类，但是G<A> 和G<B>二者不具备子父类关系，二者是并列关系。
     * 补充：类A是类B的父类，A<G> 是 B<G> 的父类
     */

    @Test
    public void test1(){
        Object obj = null;
        String str = null;
        obj = str;

        Object[] arr1 = null;
        String[] arr2 = null;
        arr1 = arr2;

        //编译不通过
//        Date date = new Date();
//        str = date;

        List<Object> list1 = null;
        List<String> list2 = new ArrayList<String>();
        //此时的list1和list2的类型不具有子父类关系
//        list1 = list2;//编译不通过
        /*
        反证法：
        假设list1 = list2;
           list1.add(123);  在list2中，会导致混入非String的数据。出错。
         */


        show(list1);
//        show(list2);//编译不通过
//        show1(list1);//编译不通过
        show1(list2);

    }

    public void show(List<Object> list){}
    public void show1(List<String> list){}


    @Test
    public void test2(){
        /** 补充：类A是类B的父类，A<G> 是 B<G> 的父类 **/
        AbstractList<String> list1 = null;//是父类或是接口都行
        ArrayList<String> list3 = null;//class ArrayList<E> extends AbstractList<E>
        List<String> list2 = null;

        list1 = list3;
        list2 = list3;

        List<String> list4 = new ArrayList<>();//
    }

}