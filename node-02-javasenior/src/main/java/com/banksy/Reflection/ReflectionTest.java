package com.banksy.Reflection;

import com.banksy.Reflection.other.Person;
import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射
 * 创建Person类的对象：getConstructor()
 * 调用对象指定的属性：getDeclaredField()
 * 调用对象指定的方法：getDeclaredMethod()
 * 调用Person类的私有结构的构造器：getDeclaredConstructor()
 * 调用Person类的私有结构的属性：getDeclaredField()
 * 调用Person类的私有结构的方法：getDeclaredMethod()
 *
 * @Author banksy
 * @Data 2022/9/26 12:55 PM
 * @Version 1.0
 **/
public class ReflectionTest {

    /** 反射之前，对于Person的操作：只能通过对象调用其内部公有属性和公有方法 **/
    @Test
    public void test1() {
        //1.创建Person类的对象
        Person p1 = new Person("Tom", 12);
        //2.通过对象，调用其内部的属性、方法
        p1.age = 10;
        System.out.println(p1.toString());
        p1.show();
        //在Person类外部，不可以通过Person类的对象调用其内部私有结构。
        //比如：name、showNation()以及私有的构造器
    }

    /** 反射之后，对于Person的操作：不仅可以调用内部公有属性、方法 还可调用私有属性、方法 **/
    @Test
    public void test2() throws Exception{
        Class clazz = Person.class;

        //1. 通过反射，创建Person类的对象。调用对象指定的属性、方法
        Constructor cons = clazz.getConstructor(String.class,int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person) obj;
        System.out.println(p.toString());
        //调用属性
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p.toString());
        //调用方法
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);

        System.out.println("*******************************");

        //2. 通过反射，可以调用Person类的私有结构的。比如：私有的构造器、方法、属性
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Person p1 = (Person) cons1.newInstance("Jerry");
        System.out.println(p1);
        //调用私有的属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"HanMeimei");
        System.out.println(p1);
        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);
        String nation = (String) showNation.invoke(p1,"中国");//相当于String nation = p1.showNation("中国")
        System.out.println(nation);
    }

    //疑问1：通过直接new的方式或反射的方式都可以调用公共的结构，开发中到底用那个？
    //建议：直接new的方式。
    //什么时候会使用：反射的方式。 反射的特征：动态性
    //疑问2：反射机制与面向对象中的封装性是不是矛盾的？如何看待两个技术？
    //不矛盾。
}