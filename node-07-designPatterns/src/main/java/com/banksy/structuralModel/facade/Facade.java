package com.banksy.structuralModel.facade;

/**
 * 外观模式
 * Provide a unified interface to a set of interfaces in a subsystem.Facade defines a higher-level
 * interface that makes the subsystem easier to use.
 * 要求一个子系统的外部与其内部的通信必须通过一个统一的对象进行。 门面模式提供一个高层次的接口， 使得子系统更易于使用。
 *
 * 角色：门面角色、子系统角色
 *
 * 优点：减少系统的相互依赖；
 *      提高了灵活性；提高安全性；
 * 缺点：门面模式最大的缺点就是不符合开闭原则，会修改门面角色代码
 * 适用场景：
 *      为一个复杂的模块或子系统提供一个供外界访问的接口；
 *      子系统相对独立——外界对子系统的访问只要黑箱操作即可；
 *      预防低水平人员带来的风险扩散
 *
 * @author banksy
 * @version 1.0
 **/
public class Facade {
    private Money money;
    private Inventory inventory;
    private Delivery delivery;

    public Facade() {
        this.money = new Money();
        this.inventory = new Inventory();
        this.delivery = new Delivery();
    }

    public void makeOrder() {
        money.deduct();
        inventory.reduce();
        delivery.add();
    }
}


class Money {
    public void deduct() {
        System.out.println("扣费用......");
    }
}
class Inventory {
    public void reduce() {
        System.out.println("减库存......");
    }
}
class Delivery {
    public void add() {
        System.out.println("加发货单......");
    }
}

class Client {
    public static void main(String[] args) {
        Facade facade = new Facade();
        facade.makeOrder();
    }
}