package com.banksy.behavioralModel.templateMethod;

/**
 * 模版方法模式：定义一个操作中的算法的框架，而将一些步骤延迟到子类中，使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤
 *
 * 优点：
 * 缺点：
 * 适用场景：
 * @author banksy
 **/
public class TemplateModel {
    public static void main(String[] args) {
        ConcreteClass1 concreteClass1 = new ConcreteClass1();
        ConcreteClass2 concreteClass2 = new ConcreteClass2();
        concreteClass1.templateMethod();
        concreteClass2.templateMethod();
    }
}

abstract class AbstractClass {
    protected abstract void doSomething();
    protected abstract void doAnything();

    public void templateMethod() {
        System.out.println("模版开始......");
        this.doSomething();
        this.doAnything();
        System.out.println("模版结束......");
    }
}

class ConcreteClass1 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("子类1，doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("子类1，doAnything");
    }
}

class ConcreteClass2 extends AbstractClass {
    @Override
    protected void doSomething() {
        System.out.println("子类2，doSomething");
    }

    @Override
    protected void doAnything() {
        System.out.println("子类2，doAnything");
    }
}