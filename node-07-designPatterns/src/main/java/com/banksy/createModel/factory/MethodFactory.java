package com.banksy.createModel.factory;

/**
 * 工厂方法模式：
 * Define an interface for creating an object,but let subclasses decide which class to
 * instantiate.Factory Method lets a class defer instantiation to subclasses.
 * 定义一个用于创建对象的接口， 让子类决定实例化哪一个类。 工厂方法使一个类的实例化延迟到其子类。
 *
 * 优点：良好的封装性， 代码结构清晰。
 *      工厂方法模式的扩展性非常优秀。
 *      屏蔽产品类。
 *      工厂方法模式是典型的解耦框架。符合迪米特法则，依赖倒置原则，里氏替换原则
 * 缺点：
 * 1、类的个数容易过多，增加复杂度
 * 2、增加了系统的抽象性和理解难度
 * 适用场景：
 * 1、创建对象需要大量重复的代码。
 * 2、客户端(应用层)不依赖于产品类实例如何被创建、如何被实现等细节
 * 3、一个类通过其子类来指定创建哪个对象
 *
 * 横向扩展，不需要修改已有代码，只需添加工厂实体类和产品实体类即可
 * @author banksy
 **/
class MethodFactoryClient {
    public static void main(String[] args) {
        MethodFactoryA methodFactoryA = new MethodFactoryA();//去指定工厂，要产品
        methodFactoryA.getProduct().print();
    }
}

//抽象工厂类
abstract class MethodFactory {
    public abstract MethodProduct getProduct();
}
//实体类，工厂A
class MethodFactoryA extends MethodFactory {
    @Override
    public MethodProduct getProduct() {
        return new MethodProduct1();
    }
}
//实体类，工厂B
class MethodFactoryB extends MethodFactory {
    @Override
    public MethodProduct getProduct() {
        return new MethodProduct2();
    }
}

//抽象产品类
abstract class MethodProduct {
    public abstract void print();
}
//实体类，产品A
class MethodProduct1 extends MethodProduct {
    @Override
    public void print() {
        System.out.println("产品1");
    }
}
//实体类，产品B
class MethodProduct2 extends MethodProduct {
    @Override
    public void print() {
        System.out.println("产品2");
    }
}