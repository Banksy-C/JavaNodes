package com.banksy.createModel.factory;

/**
 * 简单工厂：又称静态工厂方法模式；根据参数但不同返回不同类的实例；
 *
 * 简单工厂模式专门定义一个类来负责创建其他类的实例，被创建的实例通常都是具有共同的父类；
 *
 * 简单工厂模式是指由一个工厂对象决定创建哪一种产品类的实例，但它不属于GoF的23种设计模式；
 *
 * 简单工厂模式适用于工厂类负责创建的对象较少的场景，且客户端只需要传入工厂类的参数，对于如何创建对象不需要关心；
 *
 * 简单工厂模式也有缺点：工厂类的职责相对过重，不易于扩展过于复杂的产品结构，横向扩展时，需要修改已有的代码；
 *
 * @author banksy
 **/
class SimpleFactoryClient {
    public static void main(String[] args) {
        SimpleProduct simpleProduct = SimpleFactory.createProduct("A");
        simpleProduct.print();
    }
}

//工厂类
public class SimpleFactory {
    static SimpleProduct createProduct(String type) {
        if (type.equals("A"))
            return new SimpleProduct1();
        else
            return new SimpleProduct2();
    }
}

//抽象类
abstract class SimpleProduct {
    public abstract void print();
}
//实体类，产品1
class SimpleProduct1 extends SimpleProduct {
    @Override
    public void print() {
        System.out.println("产品1");
    }
}
//实体类，产品2
class SimpleProduct2 extends SimpleProduct {
    @Override
    public void print() {
        System.out.println("产品2");
    }
}