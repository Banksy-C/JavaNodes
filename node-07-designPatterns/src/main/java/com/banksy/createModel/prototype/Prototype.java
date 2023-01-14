package com.banksy.createModel.prototype;

import java.util.Date;

/**
 * 原型模式：
 * Specify the kinds of objects to create using a prototypical instance,and create new objects by copying this prototype.
 * 用原型实例指定创建对象的种类， 并且通过拷贝这些原型创建新的对象。
 *
 * 优点：性能优良【原型模式是在内存二进制流的拷贝， 要比直接new一个对象性能好很多】；
 *      逃避构造函数的约束【直接在内存中拷贝，构造函数是不会执行，减少了约束】；
 * 缺点：逃避构造函数的约束【直接在内存中拷贝，构造函数是不会执行，减少了约束】；
 *
 * 适用场景：
 * 在并发场景下，线程1在使用对象1，在还未使用结束的情况下，线程2也需要使用对象1，就会更新对象1中的属性，此时就会出现线程安全问题
 * 解决方法就是利用原型模式进行拷贝一个相同的对象进行使用；
 *
 * 扩展：
 * 可对 原型模式 + 工厂模式 => 只new一次，剩下都拷贝就行了；
 *
 * @author banksy
 **/
public class Prototype {
    public static void main(String[] args) {
        Date date = new Date();
        /**
         * 浅拷贝：不仅把值拷贝过来，把引用也拷贝过来
         **/
        System.out.println("=========================浅拷贝=======================");
        PrototypeShallowCopy shallowCopy = new PrototypeShallowCopy("浅拷贝......", date);
        PrototypeShallowCopy shallowCopy1 = shallowCopy.clone();
        System.out.println(shallowCopy.toString());
        System.out.println(shallowCopy1.toString());
        System.out.println("=========================修改date后=======================");
        date.setTime(8686767);
        System.out.println(shallowCopy.toString());
        System.out.println(shallowCopy1.toString());//克隆对象的date属性也变化了，说明两个对象同时指向同一个date


        System.out.println();
        System.out.println();
        /**
         * 深拷贝：把值拷贝，未拷贝引用
         **/
        Date date1 = new Date();
        System.out.println("=========================深拷贝=======================");
        PrototypeDeepCope deepCope = new PrototypeDeepCope("深拷贝......", date1);
        PrototypeDeepCope deepCope1 = deepCope.clone();
        System.out.println(deepCope.toString());
        System.out.println(deepCope1.toString());
        System.out.println("=========================修改date后=======================");
        date1.setTime(32525);
        System.out.println(deepCope.toString());//此时原始对象的Date属性发生改变
        System.out.println(deepCope1.toString());//克隆对象的Date未发生改变，说明两个对象指向不同的Date
    }
}
