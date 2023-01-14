package com.banksy.multiThread;

/**
 * 单例-懒汉模式
 * 使用同步机制将单例模式中的懒汉式改写为线程安全的
 * @Author banksy
 * @Data 2022/9/15 8:13 PM
 * @Version 1.0
 **/
public class LazySingle {
}

class Lazy{

    private Lazy(){}

    private static Lazy instance = null;

    public static Lazy getInstance(){
        //方式一：效率稍差
//        synchronized (Bank.class) {
//            if(instance == null){
//
//                instance = new Bank();
//            }
//            return instance;
//        }
        //方式二：效率更高
        if(instance == null){

            synchronized (Lazy.class) {
                if(instance == null){

                    instance = new Lazy();
                }
            }
        }
        return instance;
    }
}