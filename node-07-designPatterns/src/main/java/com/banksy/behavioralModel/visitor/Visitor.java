package com.banksy.behavioralModel.visitor;

import java.util.Random;

/**
 * 访问者模式
 * Represent an operation to be performed on the elements of an object structure.
 * Visitor lets you define a new operation without changing the classes of the elements on which it operates.
 * 封装一些作用于某种数据结构中的各元素的操作， 它可以在不改变数据结构的前提下定义作用于这些元素的新的操作。
 *
 * 角色：抽象访问者【抽象类或者接口， 声明访问者可以访问哪些元素， 具体到程序中就是visit方法的参数定义哪些对象是可以被访问的】；
 *      具体访问者【它影响访问者访问到一个类后该怎么干， 要做什么事情】；
 *      结构元素【元素产生者， 一般容纳在多个不同类、 不同接口的容器， 如List、 Set、 Map等， 在项目中， 一般很少抽象出这个角色】；
 *      抽象元素【接口或者抽象类， 声明接受哪一类访问者访问， 程序上是通过accept方法中的参数来定义的】；
 *      具体元素【实现accept方法， 通常是visitor.visit(this)， 基本上都形成了一种模式】；
 * 优点：符合单一职责原则；优秀的扩展性；灵活性非常高；
 * 缺点：具体元素对访问者公布细节；具体元素变更比较困难；违背了依赖倒置转原则；
 * 适用场景：业务规则要求遍历很多个不同对象；还有就是充当拦截器角色；
 *
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