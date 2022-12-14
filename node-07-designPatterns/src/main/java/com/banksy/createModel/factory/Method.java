package com.banksy.createModel.factory;

/**
 * 工厂方法模式：定义一个用于创建对象的接口，让子类决定实现哪一个类，工厂方法使一个类的实例化延迟到其子类
 *
 * 适用场景：
 * 优缺点：
 *
 * 横向扩展，不需要修改已有代码，只需添加工厂实体类和产品实体类即可
 * @author banksy
 **/
public class Method {
    public static void main(String[] args) {
        MethodFactoryA methodFactoryA = new MethodFactoryA();//去指定工厂，要产品
        methodFactoryA.getProduct().print();
    }
}

//抽象工厂类
abstract class MethodFactory {
    public abstract MethodProduct getProduct();
}
//抽象产品类
abstract class MethodProduct {
    public abstract void print();
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