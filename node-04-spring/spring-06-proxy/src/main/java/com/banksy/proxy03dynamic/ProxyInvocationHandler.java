package com.banksy.proxy03dynamic;

import com.banksy.proxy03dynamic.service.Rent;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 【代理调用处理类,自动生成代理类】
 * @Author banksy
 **/
public class ProxyInvocationHandler implements InvocationHandler {

    //被代理的接口
    private Rent rent;

    public void setRent(Rent rent) {
        this.rent = rent;
    }


    //生成代理类，重点是第二个参数，获取要代理的抽象角色！静态代理是一个角色，现在可以代理一类角色
    public Object getProxy(){
        //参数一：获取代理类的加载器；参数二：获取代理类的接口；参数三：实现类；
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),
                                      rent.getClass().getInterfaces(),
                                   this);
    }


    // 处理代理实例上的方法调用并返回结果
    // 参数一【proxy】: 代理类 ； 参数二【method】: 代理类的调用处理程序的方法对象.
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        seeHouse();
        //核心：本质利用反射实现！
        Object result = method.invoke(rent, args);
        fare();
        return result;
    }


    //看房
    public void seeHouse(){
        System.out.println("带房客看房");
    }
    //收中介费
    public void fare(){
        System.out.println("收中介费");
    }
}
