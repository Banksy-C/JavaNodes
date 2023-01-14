package com.banksy.createModel.singleton;

import java.lang.reflect.Constructor;

/**
 * 单例模式：
 * Ensure a class has only one instance, and provide a global point of access to it.
 * 确保某一个类只有一个实例，而且自行实例化并向整个系统提供这个实例。
 * 分为懒汉式和饿汉式
 *
 * 优点：
 * 由于单例模式在内存中只有一个实例，减少了内存开支，特别是一个对象需要频繁地创建、销毁时，而且创建或销毁时性能又无法优化，单例模式的优势就非常明显；
 * 当一个对象的产生需要比较多的资源时，如读取配置、产生其他依赖对象时，则可以通过在应用启动时直接产生一个单例对象，然后用永久驻留内存的方式来解决；（在JavaEE中采用单例模式时需要注意JVM垃圾回收机制）；
 * 单例模式可以避免对资源的多重占用，例如一个写文件动作，由于只有一个实例存在内存中，避免对同一个资源文件的同时写操作；
 * 单例模式可以在系统设置全局的访问点，优化和共享资源访问，例如可以设计一个单例类，负责所有数据表的映射处理；
 *
 * 缺点：
 * 单例模式一般没有接口，扩展很困难，若要扩展，除了修改代码基本上没有第二种途径可以实现。
 * 单例模式为什么不能增加接口呢？ 因为接口对单例模式是没有任何意义的，它要求“自行实例化”，并且提供单一实例、接口或抽象类是不可能被实例化的。
 * 单例模式对测试是不利的：在并行开发环境中，如果单例模式没有完成，是不能进行测试的，没有接口也不能使用mock的方式虚拟一个对象。
 * 单例模式与单一职责原则有冲突：一个类应该只实现一个逻辑，而不关心它是否是单例的，是不是要单例取决于环境，单例模式把“要单例”和业务逻辑融合在一个类中。
 *
 * 适用场景：
 * 在一个系统中，要求一个类有且仅有一个对象，如果出现多个对象就会出现“不良反应”，可以采用单例模式，具体的场景如下：
 * 要求生成唯一序列号的环境；
 * 在整个项目中需要一个共享访问点或共享数据，例如一个Web页面上的计数器，可以不用把每次刷新都记录到数据库中，使用单例模式保持计数器的值，并确保是线程安全的；
 * 创建一个对象需要消耗的资源过多， 如要访问IO和数据库等资源；
 * 需要定义大量的静态常量和静态方法（如工具类） 的环境，可以采用单例模式（当然，也可以直接声明为static的方式）。
 *
 * @author banksy
 **/
public class Singleton {

}


/**
 * 懒汉式：在真正需要使用时才去创建该对象；被外部类调用的时候，内部类才会加载
 * 在开发中对内存要求非常高时，使用懒汉式
 **/

/** 一 **/
class LazySingletonV1 {

    //声明对象
    private static LazySingletonV1 lazySingletonV1;
    //限制产生多个对象
    private LazySingletonV1() {
        System.out.println(Thread.currentThread().getName());//打印线程名称
    }

    /** 一
     * 创建对象方法时在程序使用对象前，先判断该对象是否实例化，若实例化直接返回该对象，否则先执行实例化操作；
     * 但是，在并发的情况下，若两个线程同时判断，则会变成双例，则需要解决线程安全问题
     */
    public static LazySingletonV1 getLazySingletonV1() {
        if (lazySingletonV1 == null) {
            lazySingletonV1 = new LazySingletonV1();
        }
        return lazySingletonV1;
    }

    //类中其他方法，尽量是static的
    public static void doSomething() {}

    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            new Thread(LazySingletonV1::getLazySingletonV1).start();
        }
    }
}

/** 二 **/
class LazySingletonV2 {

    //声明对象
    private static LazySingletonV2 lazySingletonV2;
    //限制产生多个对象
    private LazySingletonV2() {}

    /** 二
     * 解决线程安全问题：在方法上加锁，或在对象上加锁
     * 虽然规避了线程安全问题，但又：每次获取对象前都要先获取锁，并发性能差
     */
    public static synchronized LazySingletonV2 getLazySingletonV2a() {
        if (lazySingletonV2 == null) {
            lazySingletonV2 = new LazySingletonV2();
        }
        return lazySingletonV2;
    }
/** 或者 **/
    public static LazySingletonV2 getLazySingletonV2b() {
        synchronized (LazySingletonV2.class) {
            if (lazySingletonV2 == null) {
                lazySingletonV2 = new LazySingletonV2();
            }
        }
        return lazySingletonV2;
    }

    //类中其他方法，尽量是static的
    public static void doSomething() {}
}

/** 三 **/
class LazySingletonV3 {

    //声明对象
    private static LazySingletonV3 lazySingletonV3;
    //限制产生多个对象
    private LazySingletonV3() {}

    /** 三
     * 解决并发安全 + 性能低效，也称为：Double Check + Lock [双检查锁]
     * 但还存在：指令重排序问题
     */
    public static LazySingletonV3 getLazySingletonV3() {
        if (lazySingletonV3 == null) {        //只有在第一次未实例化时，线程才会抢锁
            synchronized (LazySingletonV3.class) {
                if (lazySingletonV3 == null) {
                    lazySingletonV3 = new LazySingletonV3();
                }
            }
        }
        return lazySingletonV3;
    }

    //类中其他方法，尽量是static的
    public static void doSomething() {}
}

/** 四 **/
class LazySingletonV4 {
    /**
     * 在上面的基础上
     * 指令重排问题：在声明对象时，加 volatile 关键字修饰变量
     * 可保证其指令执行顺序不会发生变化，在多线程环境下就不会发生NPE异常
     */
    //声明对象
    private static volatile LazySingletonV4 lazySingletonV4;
    //限制产生多个对象
    private LazySingletonV4() {}

    public static LazySingletonV4 getLazySingletonV4() {
        if (lazySingletonV4 == null) {        //只有在第一次未实例化时，线程才会抢锁
            synchronized (LazySingletonV4.class) {
                if (lazySingletonV4 == null) {
                    lazySingletonV4 = new LazySingletonV4();
                }
            }
        }
        return lazySingletonV4;
    }

    //类中其他方法，尽量是static的
    public static void doSomething() {}

    public static void main(String[] args) {
        LazySingletonV4 v1 = LazySingletonV4.getLazySingletonV4();
        LazySingletonV4 v2 = LazySingletonV4.getLazySingletonV4();
        System.out.println(v1);
        System.out.println(v2);
    }
}

/** 五 **/
class LazySingletonV5 {
    /**
     * 这种模式兼顾饿汉式单例模式的内存浪费问题 和 synchronized性能问题
     * 内部类一定是要在方法调用之前初始化，巧妙地避免了线程安全问题。
     */
    //在使用LazySingletonV5的时候，会默认先初始化内部类
    //如果没有使用，内部类则不加载
    private LazySingletonV5() {
        System.out.println(Thread.currentThread().getName());//打印线程名称
    }
    //每一个关键字都不是多余的，static是为了使单例的空间共享，保证这个方法不被重写、重载
    public static LazySingletonV5 getLazySingletonV5() {
        return LazyHolder.LAZY;//在返回结果前，一定会先加载内部类
    }
    //默认不加载
    private static class LazyHolder {
        private static final LazySingletonV5 LAZY = new LazySingletonV5();
    }

    //类中其他方法，尽量是static的
    public static void doSomething() {}

    public static void main(String[] args) {
        for (int i = 0; i < 10 ; i++) {
            new Thread(LazySingletonV5::getLazySingletonV5).start();
        }
    }
}


/**
 * 饿汉式：在类加载时已经创建好该对象，等待被程序使用
 * 对内存要求不高时，使用饿汉式，简单不易错，且没有并发安全和性能问题
 **/
class HungrySingleton {

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




//以上都是不安全的，反射可以破解

//反射破坏单例模式
class ReflectionBreakSingleton {
    public static void main(String[] args) {
        try {
            //先正常获取单例对象
            LazySingletonV4 instance = LazySingletonV4.getLazySingletonV4();

            //进行破坏，获得空参构造器
            Constructor<LazySingletonV4> constructor = LazySingletonV4.class.getDeclaredConstructor();
            //强制访问
            constructor.setAccessible(true);
            //暴力初始化
            LazySingletonV4 instance2 = constructor.newInstance();

            System.out.println(instance);
            System.out.println(instance2);
            System.out.println(instance == instance2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
//反射不能破坏枚举单例


//一个单例对象创建后，有时候需要将对象序列化后然后写入磁盘，下次使用时再从磁盘中读取对象，并进行反序列化，将其转化为内存对象。
// 反序列化后的对象会重新分配内存，即重新创建。如果序列化的目标对象为单例对象，就违背了单例模式的初衷，相当于破坏了单例，下面来看一段代码：



