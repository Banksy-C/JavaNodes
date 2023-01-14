package com.banksy.createModel.factory;

/**
 * 抽象工厂模式：
 * Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
 * 为创建一组相关或相互依赖的对象提供一个接口， 而且无须指定它们的具体类。
 *
 * 优点： 封装性，【每个产品的实现类不是高层模块要关心的，它关心的是接口，是抽象；
 *              它不关心对象是如何创建出来，关心由谁负责的，工厂类， 只要知道工厂类是谁，就能创建出一个需要的对象】
 *       产品族内的约束为非公开状态
 * 缺点：
 *      横向扩展容易， 纵向扩展困难。
 * 适用场景：
 *      一个对象族都有相同的约束， 则可以使用抽象工厂模式。
 *
 * @author banksy
 **/
class AbstractFactoryClient {
    public static void main(String[] args) {
        AbstractFactory abstractFactoryA = new AbstractFactoryA();
        abstractFactoryA.abstractProduct1().print();//A工厂能造产品1，没有指定具体产品类
        abstractFactoryA.abstractProduct2().print();//A工厂能造产品2
    }
}

//任何工厂都能造，这两个产品
//抽象工厂，超级工厂
abstract class AbstractFactory {
    public abstract AbstractProduct1 abstractProduct1();//生产产品1
    public abstract AbstractProduct2 abstractProduct2();//生产产品2
}
//抽象类，产品1
abstract class AbstractProduct1 {
    public abstract void print();
}
//抽象类，产品2
abstract class AbstractProduct2 {
    public abstract void print();
}

//实体类，工厂A
class AbstractFactoryA extends AbstractFactory {
    @Override
    public AbstractProduct1 abstractProduct1() {
        return new AbstractProductA1();
    }

    @Override
    public AbstractProduct2 abstractProduct2() {
        return new AbstractProductA2();
    }
}
//实体类，工厂B
class AbstractFactoryB extends AbstractFactory {
    @Override
    public AbstractProduct1 abstractProduct1() {
        return new AbstractProductB1();
    }

    @Override
    public AbstractProduct2 abstractProduct2() {
        return new AbstractProductB2();
    }
}

//实体类，工厂A产品1
class AbstractProductA1 extends AbstractProduct1 {
    @Override
    public void print() {
        System.out.println("A工厂产品1");
    }
}
//实体类，工厂B产品1
class AbstractProductB1 extends AbstractProduct1 {
    @Override
    public void print() {
        System.out.println("B工厂产品1");
    }
}
//实体类，工厂A产品2
class AbstractProductA2 extends AbstractProduct2 {
    @Override
    public void print() {
        System.out.println("A工厂产品2");
    }
}
//实体类，工厂B产品2
class AbstractProductB2 extends AbstractProduct2 {
    @Override
    public void print() {
        System.out.println("B工厂产品2");
    }
}