package com.banksy.behavioralModel.visitor;

import java.util.Random;

/**
 * 访问者模式
 **/
class VisitorClient {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            Element element = ObjectStruture.createElement();
            element.accept(new ConcreteVisitor());
        }
    }
}

//抽象访问者
public interface Visitor {
    //可以访问哪些对象
    public void visit(ConcreteElement1 ce1);
    public void visit(ConcreteElement2 ce2);
}
//具体访问者
class ConcreteVisitor implements Visitor {
    @Override
    public void visit(ConcreteElement1 ce1) {
        ce1.doSomething();
    }

    @Override
    public void visit(ConcreteElement2 ce2) {
        ce2.doSomething();
    }
}
//结构元素
class ObjectStruture {
    //对象生成器，通过一个工厂方法模式模拟
    public static Element createElement() {
        Random random = new Random();
        if (random.nextInt(100) > 50) {
            return new ConcreteElement1();
        }else {
            return new ConcreteElement2();
        }
    }
}

//抽象元素
abstract class Element {
    //定义业务逻辑
    public abstract void doSomething();
    //允许谁来访问
    public abstract void accept(Visitor visitor);
}
//具体元素
class ConcreteElement1 extends Element {
    @Override
    public void doSomething() {
        System.out.println("1处理业务......");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
class ConcreteElement2 extends Element {
    @Override
    public void doSomething() {
        System.out.println("2处理业务......");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}