package com.banksy.behavioralModel.mediator;

/**
 * 中介者模式
 * Define an object that encapsulates how a set of objects interact.
 * Mediator promotes loose coupling by keeping objects from referring to each other explicitly,
 * and it lets you vary their interaction independently.
 * 用一个中介对象封装一系列的对象交互，中介者使各对象不需要显示地相互作用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
 *
 * 角色：抽象中介者角色、具体中介者角色、同事角色；
 * 优点：减少类间的依赖，把原有的一对多的依赖变成了一对一的依赖，同事类只依赖中介者，减少了依赖，当然同时也降低了类间的耦合；
 * 缺点：中介者会膨胀得很大，而且逻辑复杂，容易被误用；
 * 适用场景：ORM框架(交互各个数据库)
 *
 **/
class MediatorClient {
    public static void main(String[] args) {
        ConcreteMediator mediator = new ConcreteMediator();

        ConcreteColleague1 colleague1 = new ConcreteColleague1();
        ConcreteColleague2 colleague2 = new ConcreteColleague2();

        colleague1.setMediator(mediator);
        colleague2.setMediator(mediator);

        colleague1.fly();
        colleague1.success();
        System.out.println("==========");
        colleague2.fly();
        colleague2.success();
        System.out.println("==========");
        colleague1.land();
        colleague1.success();
    }
}
//抽象中介者角色
public abstract class Mediator {
    abstract void acceptRequest(Colleague colleague, String action);
}
//具体中介者角色
class ConcreteMediator extends Mediator {
    private boolean canDo = true;
    @Override
    void acceptRequest(Colleague colleague, String action) {
        if ("fly".equals(action) || "land".equals(action)) {
            if (canDo == true) {
                System.out.println("允许！");
                canDo = false;
            }else {
                System.out.println("不允许！");
            }
        }
        if ("success".equals(action)) {
            canDo = true;
        }
    }
}

//抽象同事角色
abstract class Colleague {
    abstract void fly();
    abstract void land();
    abstract void success();
}
//具体同事角色
class ConcreteColleague1 extends Colleague {
    ConcreteMediator mediator;

    public void setMediator(ConcreteMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    void fly() {
        System.out.println("1请求起飞......");
        mediator.acceptRequest(this, "fly");
    }

    @Override
    void land() {
        System.out.println("1请求降落......");
        mediator.acceptRequest(this, "land");
    }

    @Override
    void success() {
        System.out.println("1完成......");
        mediator.acceptRequest(this, "success");
    }
}
class ConcreteColleague2 extends Colleague {
    ConcreteMediator mediator;

    public void setMediator(ConcreteMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    void fly() {
        System.out.println("2请求起飞......");
        mediator.acceptRequest(this, "fly");
    }

    @Override
    void land() {
        System.out.println("2请求降落......");
        mediator.acceptRequest(this, "land");
    }

    @Override
    void success() {
        System.out.println("2完成......");
        mediator.acceptRequest(this, "success");
    }
}