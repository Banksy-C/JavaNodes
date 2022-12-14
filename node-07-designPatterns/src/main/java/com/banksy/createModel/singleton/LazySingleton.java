package com.banksy.createModel.singleton;

/**
 * 懒汉式：在真正需要使用时才去创建该对象
 * 在开发中对内存要求非常高时，使用懒汉式
 *
 * @author banksy
 **/
public class LazySingleton {

    //声明对象
    private static volatile LazySingleton lazySingleton;
    //限制产生多个对象
    private LazySingleton() {}


    /** 一
     * 创建对象方法时在程序使用对象前，先判断该对象是否实例化，若实例化直接返回该对象，否则先执行实例化操作；
     * 但是，在并发的情况下，若两个线程同时判断，则会变成双例，则需要解决线程安全问题
     */
//    public static LazySingleton getLazySingleton() {
//        if (lazySingleton == null) {
//            LazySingleton lazySingleton = new LazySingleton();
//        }
//        return lazySingleton;
//    }
    /** 二
     * 解决线程安全问题：在方法上加锁，或在对象上加锁
     * 虽然规避了线程安全问题，但又：每次获取对象前都要先获取锁，并发性能差
     */
//    public static synchronized LazySingleton getLazySingleton() {
//        if (lazySingleton == null) {
//            LazySingleton lazySingleton = new LazySingleton();
//        }
//        return lazySingleton;
//    }
/** 或者 **/
//    public static LazySingleton getLazySingleton() {
//        synchronized (LazySingleton.class) {
//            if (lazySingleton == null) {
//                LazySingleton lazySingleton = new LazySingleton();
//            }
//        }
//        return lazySingleton;
//    }
    /** 三
     * 解决并发安全 + 性能低效，也称为：Double Check + Lock
     * 但还存在：指令重排序问题
     */
    public static LazySingleton getLazySingleton() {
        if (lazySingleton == null) {        //只有在第一次未实例化时，线程才会抢锁
            synchronized (LazySingleton.class) {
                if (lazySingleton == null) {
                    LazySingleton lazySingleton = new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

    /**
     * 指令重排问题：在声明对象时，加 volatile 关键字修饰变量
     * 可保证其指令执行顺序不会发生变化，在多线程环境下就不会发生NPE异常
     */


    //类中其他方法，尽量是static的
    public static void doSomething() {}
}