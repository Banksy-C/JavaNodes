package com.banksy.generics.GenericsWildcard;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 通配符的使用
 * 通配符：?
 * 若想转换两个类，但这两个类不具备子父类关系
 *
 *
 * @Author banksy
 * @Data 2022/9/21 11:10 PM
 * @Version 1.0
 **/
public class GenericsTest {

    @Test
    public void test1(){
        List<Object> list1 = null;
        List<String> list2 = null;
        /** 类A是类B的父类，G<A>和G<B>是没有关系的，二者共同的父类是：G<?> **/
        List<?> list = null;

        list = list1;//Object类型能放
        list = list2;//String类型也能放
        //编译通过
//        print(list1);
//        print(list2);

        //？的操作
        List<String> list3 = new ArrayList<>();
        list3.add("AA");
        list3.add("BB");
        list3.add("CC");

        list = list3;

        /** 添加(写入)：对于List<?>就不能向其内部添加数据。  除了添加null之外。 **/
//        list.add("DD");
//        list.add('?');
        //list.add(null);//因为add对于list添加的是对象，不管什么对象都能赋值为null，所以允许添加null；但没什么意义

        /** 获取(读取)：允许读取数据，读取的数据类型为Object。 **/
        Object o = list.get(0);
        System.out.println(o);
    }

    public void print(List<?> list){
        Iterator<?> iterator = list.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            System.out.println(obj);
        }
    }


    /*
    3.有限制条件的通配符的使用。
        ? extends A:【指定上限，使用时指定的类型必须是继承某个类，<=】
                G<? extends A> 可以作为G<A>和G<B>的父类，其中B是A的子类
        ? super A:【指定下限，使用时指定的类型不能小于操作的类，>=】
                G<? super A> 可以作为G<A>和G<B>的父类，其中B是A的父类

     */
    @Test
    public void test2(){
        List<? extends Person> list1 = null;
        List<? super Person> list2 = null;

        List<Student> list3 = new ArrayList<Student>();
        List<Person> list4 = new ArrayList<Person>();
        List<Object> list5 = new ArrayList<Object>();

        list1 = list3;
        list1 = list4;
//        list1 = list5;

//        list2 = list3;
        list2 = list4;
        list2 = list5;

        //读取数据：
        list1 = list3;
        Person p = list1.get(0);
        //编译不通过
        //Student s = list1.get(0);

        list2 = list4;
        Object obj = list2.get(0);
        ////编译不通过
//        Person obj = list2.get(0);

        //写入数据：
        //编译不通过
//        list1.add(new Student());

        //编译通过
        list2.add(new Person());
        list2.add(new Student());
    }
}