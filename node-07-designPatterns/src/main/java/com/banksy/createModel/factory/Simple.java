package com.banksy.createModel.factory;

/**
 * 简单工厂：又称静态工厂方法模式；根据参数但不同返回不同类的实例
 * 简单工厂模式专门定义一个类来负责创建其他类的实例，被创建的实例通常都是具有共同的父类
 *
 * 适用场景：
 * 优缺点：
 *
 * 横向扩展时，需要修改已有的代码
 * @author banksy
 **/
public class Simple {
    public static void main(String[] args) {
        SimpleProduct simpleProduct = SimpleFactory.createProduct("A");
        simpleProduct.print();
    }
}
//工厂类
class SimpleFactory {
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