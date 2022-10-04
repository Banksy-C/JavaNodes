package com.banksy.Reflection.runingStructure.Proxy;

/**
 * 静态代理
 * @Author banksy
 * @Data 2022/10/3 9:13 PM
 * @Version 1.0
 **/
//接口【抽象角色，产品衣服】
interface ClothFactory{
    void produceCloth();
}

//代理类【真实角色，造衣服工厂】
class ProxyClothFactory implements ClothFactory{

    private ClothFactory factory;//用被代理类对象进行实例化

    public ProxyClothFactory(ClothFactory factory){//带参构造器
        this.factory = factory;
    }

    @Override
    public void produceCloth() {
        System.out.println("代理工厂做一些准备工作");
        factory.produceCloth();
        System.out.println("代理工厂做一些后续的收尾工作");
    }
}

//被代理类1【代理角色1，生产什么牌子的衣服】
class NikeClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Nike工厂生产一批运动服");
    }
}

//被代理类2【代理角色1，生产什么牌子的衣服】
class AdidasClothFactory implements ClothFactory{

    @Override
    public void produceCloth() {
        System.out.println("Adidas工厂生产一批运动服");
    }
}

//【客户角色，去找代工厂，需要什么牌子的衣服】
public class StaticProxyTest {
    public static void main(String[] args) {

        //创建被代理类的对象【贴牌厂要卖衣服】
        ClothFactory nike = new NikeClothFactory();
        ClothFactory adidas = new AdidasClothFactory();
        //创建代理类的对象【】
        ClothFactory proxyClothFactory = new ProxyClothFactory(nike);
        ClothFactory proxyClothFactory1 = new ProxyClothFactory(adidas);
        //执行代理类中的produceCloth()
        proxyClothFactory.produceCloth();
        System.out.println();
        proxyClothFactory1.produceCloth();

    }
}