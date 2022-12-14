package com.banksy.createModel.singleton;

/**
 * 饿汉式：在类加载时已经创建好该对象，等待被程序使用
 * 对内存要求不高时，使用饿汉式，简单不易错，且没有并发安全和性能问题
 * @author banksy
 **/
public class HungrySingleton {

    //在类加载时创建该对象
    private static final HungrySingleton hungrySingleton = new HungrySingleton();
    //限制产生多个对象
    private HungrySingleton() {}
    //通过该方法获取实例对象
    public static HungrySingleton getHungrySingleton() {
        return hungrySingleton;
    }

    //类中其他方法，尽量是static的
    public static void doSomething() {}

}