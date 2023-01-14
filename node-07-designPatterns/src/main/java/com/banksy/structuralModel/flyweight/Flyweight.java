package com.banksy.structuralModel.flyweight;

import java.util.HashMap;

/**
 * Use sharing to support large numbers of fine-grained objects efficiently.
 * 使用共享对象可有效地支持大量的细粒度的对象。
 *
 * 其中存在两种状态：内部状态：不会随着环境的改变而改变的可共享部分；
 *                外部状态：随着环境的该改变而改变的不可共享部分；将外部状态外部化；
 *
 * 角色：抽象享元角色、具体享元角色、不可共享的享元角色、享元工厂
 *
 * @author banksy
 * @version 1.0
 **/
public class Flyweight {
}

class BoxFactory {

    private HashMap<String, Box> map;
    //在构造方法中进行初始化操作
    private BoxFactory() {
        map = new HashMap<String, Box>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());
    }

    private static BoxFactory factory = new BoxFactory();
    //提供一个方法获取该工厂类对象
    public static BoxFactory getInstance() {
        return factory;
    }
    //根据名称获取图形对象
    public Box getShape(String name) {
        return map.get(name);
    }
}

abstract class Box {
    //获取图形
    public abstract String getShape();
    //显示图形及颜色
    public void display(String color) {
        System.out.println("方块形状：" + getShape() + "，颜色：" + color);
    }
}

class IBox extends Box {
    @Override
    public String getShape() {
        return "I";
    }
}

class LBox extends Box {
    @Override
    public String getShape() {
        return "L";
    }
}

class OBox extends Box {
    @Override
    public String getShape() {
        return "O";
    }
}