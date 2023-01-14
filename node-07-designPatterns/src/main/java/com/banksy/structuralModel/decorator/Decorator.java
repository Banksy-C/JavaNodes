package com.banksy.structuralModel.decorator;

/**
 * 装饰模式
 * Attach additional responsibilities to an object dynamically keeping the same interface.
 * Decorators provide a flexible alternative to subclassing for extending functionality.
 * 动态地给一个对象添加一些额外的职责。
 * 就增加功能来说， 装饰模式相比生成子类更为灵活。
 *
 * 角色：抽象角色、具体实现角色、装饰角色、装饰具体实现角色
 *
 * 优点：装饰类和被装饰类可以独立发展，而不会相互耦合；
 *      装饰模式是继承关系的一个替代方案；
 *      装饰模式可以动态地扩展一个实现类的功能；
 * 缺点：多层的装饰是比较复杂的。尽量减少装饰类的数量，以便降低系统的复杂度。
 * 适用场景：需要扩展一个类的功能， 或给一个类增加附加功能；
 *         需要动态地给一个对象增加功能， 这些功能可以再动态地撤销；
 *         需要为一批的兄弟类进行改装或加装功能， 当然是首选装饰模式；
 *
 * @author banksy
 * @version 1.0
 **/
public class Decorator {
    public static void main(String[] args) {
        FastFood fastFood = new FiredRice();
        System.out.println(fastFood.getDesc() + "：" + fastFood.cost() + "元");
        fastFood = new Egg(fastFood);
        System.out.println(fastFood.getDesc() + "：" + fastFood.cost() + "元");
        fastFood = new Bacon(fastFood);
        System.out.println(fastFood.getDesc() + "：" + fastFood.cost() + "元");
    }
}

//装饰抽象角色，装饰菜
abstract class Garnish extends FastFood {

    private FastFood fastFood;

    public Garnish(float price, String desc, FastFood fastFood) {
        super(price, desc);
        this.fastFood = fastFood;
    }

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }
}
//装饰具体实现角色，加鸡蛋
class Egg extends Garnish {
    public Egg(FastFood fastFood) {
        super(1, "鸡蛋", fastFood);
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
//装饰具体实现角色，加培根
class Bacon extends Garnish {
    public Bacon(FastFood fastFood) {
        super(2, "培根", fastFood);
    }

    @Override
    public float cost() {
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}


//抽象角色，快餐
abstract class FastFood {
    private float price;//价格
    private String desc;//描述

    public FastFood() {
    }

    public FastFood(float price, String desc) {
        this.price = price;
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public abstract float cost();
}
//具体实现角色，炒米
class FiredRice extends FastFood {
    public FiredRice() {
        super(10, "炒饭！");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}
//具体实现角色，炒面
class FiredNoodles extends FastFood {

    public FiredNoodles() {
        super(12, "炒面！");
    }

    @Override
    public float cost() {
        return getPrice();
    }
}