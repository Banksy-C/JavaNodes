package com.banksy.reflection.runingStructure.Proxy;

/**
 * 静态代理
 * @Author banksy
 * @Data 2022/10/3 9:13 PM
 * @Version 1.0
 **/
//抽象角色：【一般使用接口或者抽象类来实现】
interface ClothesFactory {
    void makeClothes();//造衣服功能
}

//真实角色：【被代理类，真正的实现接口方法，公共操作】实现做衣服的功能、造衣服工厂
class ClothesFactoryImpl implements ClothesFactory{
    @Override
    public void makeClothes() {
        System.out.println("衣服造好，请取走～");
    }
}

//代理角色1：【代理类; 代理真实角色后 , 一般会做一些附属的操作】nike工厂
class NikeClothesFactory implements ClothesFactory{
    private ClothesFactory clothesFactory;//代理类对象进行实例化

    public NikeClothesFactory(ClothesFactory clothesFactory) {
        this.clothesFactory = clothesFactory;
    }

    @Override
    public void makeClothes() {
        System.out.println("Nike工厂：等我去到工厂给你造！");
        clothesFactory.makeClothes();
    }
}

//代理角色2：【代理类; 代理真实角色后 , 一般会做一些附属的操作】Adidas工厂
class AdidasClothesFactory implements ClothesFactory{
    private ClothesFactory clothesFactory;//代理类对象进行实例化

    public AdidasClothesFactory(ClothesFactory clothesFactory) {
        this.clothesFactory = clothesFactory;
    }

    @Override
    public void makeClothes() {
        System.out.println("Adidas工厂：等我去到工厂给你造！");
        clothesFactory.makeClothes();
    }
}

//客户角色：【使用代理角色来进行一些操作】去找什么工厂，买什么衣服
public class StaticProxyTest {
    public static void main(String[] args) {
        //创建被代理类的对象【做工厂】
        ClothesFactoryImpl clothesFactory = new ClothesFactoryImpl();
        //创建代理类的对象【贴牌厂去找做工厂产出】
        NikeClothesFactory nikeClothesFactory = new NikeClothesFactory(clothesFactory);
        AdidasClothesFactory adidasClothesFactory = new AdidasClothesFactory(clothesFactory);
        //执行代理类中的方法【客户找贴牌厂要造衣服】
        System.out.println("客户：给我造Nike！");
        nikeClothesFactory.makeClothes();
        System.out.println();
        System.out.println("客户：给我造Adidas！");
        adidasClothesFactory.makeClothes();
    }
}