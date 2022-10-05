package com.banksy.Reflection.runingStructure.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 【动态代理】
 *
 * @Author banksy
 * @Data 2022/10/3 9:14 PM
 * @Version 1.0
 **/

//抽象角色：【一般使用接口或者抽象类来实现】工厂
interface Factory{
    void produceCloth();
    void produceCotton();
}

//真实角色：【被代理类，真正的实现接口方法，公共操作】工厂要造用品
class ProxyFactory implements Factory{

    @Override
    public void produceCloth() {
        System.out.println("这里是布料代工厂");
    }

    @Override
    public void produceCotton() {
        System.out.println("这里是棉花代工厂");
    }
}

/**
    要想实现动态代理，需要解决的问题？
    问题一：如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象。
    问题二：当通过代理类的对象调用方法a时，如何动态的去调用被代理类中的同名方法a。
 **/
//代理角色：【代理真实角色 ; 代理真实角色后 , 一般会做一些附属的操作】
//动态生成代理类，重点是第二个参数，获取要代理的抽象角色！静态代理是一个角色，现在可以代理一类角色
class getProxy{
    //调用此方法，返回一个代理类的对象。解决问题一
    public static Object getProxyInstance(Object obj){//obj:传入要代理类的对象
        //要代理对象的调用处理程序
        MyInvocationHandler handler = new MyInvocationHandler();
        //设置要代理的对象
        handler.setTarget(obj);
        //proxy可以得到代理对象，还能new代理对象；下面返回new一个代理对象=动态生产一个代理对象；
        //Proxy.newProxyInstance的 参数一：获取代理类的加载器；参数二：获取代理类的接口；参数三：实现类；
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), handler);
    }
}

class MyInvocationHandler implements InvocationHandler {
    private Object target;//需要使用被代理类的对象进行赋值
    public void setTarget(Object target) {
        this.target = target;
    }
    //当我们通过代理类的对象，调用方法a时，就会自动的调用如下的方法：invoke()【invoke是通过反射执行方法】
    /** 将被代理类要执行的方法a的功能就声明在invoke()中 **/
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ProduceFactory(method.getName());
        //method:即为代理类对象调用的方法，此方法也就作为了被代理类对象要调用的方法
        //target:被代理类的对象
        Object result = method.invoke(target, args);
        return result;
    }

    public void ProduceFactory(String methodName){
        System.out.println("执行了"+methodName+"方法");
    }
}

//客户角色：【使用代理角色来进行一些操作】
public class DynamicProxyTest {
    public static void main(String[] args) {
        //1.创建代理类对象
        ProxyFactory pcf1 = new ProxyFactory();
        //2.代理实例的调用处理程序，并设置代理类对象；在获取代理类时已经new过了
        //3.将要代理的对象pcf1传入，动态生成一个代理类；
        Factory proxyInstance = (Factory) getProxy.getProxyInstance(pcf1);
        //4.当通过代理类对象调用方法时，会自动的调用被代理类中同名的方法
        proxyInstance.produceCloth();
        proxyInstance.produceCotton();

        System.out.println("*******************************************************************************");

        ClothesFactoryImpl clothesFactory = new ClothesFactoryImpl();
        ClothesFactory proxyClothesFactory = (ClothesFactory) getProxy.getProxyInstance(clothesFactory);
        System.out.println("客户：我要衣服！");
        proxyClothesFactory.makeClothes();
    }
}