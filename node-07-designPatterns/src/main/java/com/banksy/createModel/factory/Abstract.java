package com.banksy.createModel.factory;

/**
 * 抽象工厂模式：为创建一组相关或相互依赖的对象提供一个接口，而且无需指定它的具体类
 *
 * 适用场景：
 * 优缺点：
 *
 * @author banksy
 **/
public class Abstract {
    public static void main(String[] args) {
        AbstractFactoryA abstractFactoryA = new AbstractFactoryA();
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