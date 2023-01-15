package com.banksy.behavioralModel.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * Define a one-to-many dependency between objects so that when one object changes state,
 * all its dependents are notified and updated automatically.
 * 定义对象间一种一对多的依赖关系， 使得每当一个对象改变状态， 则所有依赖于它的对象都会得到通知并被自动更新。
 *
 * 角色：抽象主题、具体主题、抽象观察者、具体观察者
 * 优点：观察者和主题之间是抽象耦合的；建立一套触发机制
 * 缺点：需要考虑一下开发效率和运行效率问题， 一个被观察者， 多个观察者， 开发和调试就会比较复杂，
 *      而且在Java中消息的通知默认是顺序执行， 一个观察者卡壳， 会影响整体的执行效率。 在这种情况下， 一般考虑采用异步的方式
 * 适用场景：关联行为场景；事件多级触发场景；跨系统的消息交换场景， 如消息队列的处理机制。
 *
 * @author banksy
 * @version 1.0
 **/
class ObserverClient {
    public static void main(String[] args) {
        //创建一个具体主题
        ConcreteSubject subject = new ConcreteSubject();
        //定义具体观察者
        Observer observer1 = new ConcreteObserver1();
        Observer observer2 = new ConcreteObserver2();

        //主题被观察
        observer1.follow(subject);
        observer2.follow(subject);

        subject.start();//开播
        System.out.println("======");
        subject.end();//下播
    }
}

//抽象主题：抖音主播，粉丝观察主播
abstract class Subject {
    //增加观察者
    abstract void addObserver(Observer obs);
    //删除观察者
    abstract void delObserver(Observer obs);
    //通知所有观察者
    abstract void notifyObserver(String msg);

}
//具体主题：真实主题
class ConcreteSubject extends Subject {
    //主播又多少粉丝
    List<Observer> obsList = new ArrayList<>();
    @Override
    void addObserver(Observer obs) {
        this.obsList.add(obs);
    }

    @Override
    void delObserver(Observer obs) {
        this.obsList.remove(obs);
    }

    @Override
    void notifyObserver(String msg) {
        for (Observer obs : this.obsList) {
            obs.acceptMsg(msg);
        }
    }
    //具体业务：通知开播
    public void start() {
        System.out.println("开播了！！！");
        this.notifyObserver("加入---");
    }
    //具体业务：下播了
    public void end() {
        System.out.println("下播了！");
        this.notifyObserver("退出---");
    }
}

//抽象观察者
public abstract class Observer {
    abstract void acceptMsg(String msg);

    void follow(Subject sub) {
        sub.addObserver(this);
    }
}

//具体观察者1
class ConcreteObserver1 extends Observer {
    @Override
    void acceptMsg(String msg) {
        System.out.println(msg + "粉丝1");
    }
}
//具体观察者2
class ConcreteObserver2 extends Observer {
    @Override
    void acceptMsg(String msg) {
        System.out.println(msg + "粉丝2");
    }
}