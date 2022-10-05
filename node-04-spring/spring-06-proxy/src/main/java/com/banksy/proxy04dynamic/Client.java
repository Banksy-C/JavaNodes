package com.banksy.proxy04dynamic;

import com.banksy.proxy02static.service.Impl.UserServiceImpl;
import com.banksy.proxy02static.service.UserService;

/**
 * @Author banksy
 * @Data 2022/10/4 6:43 PM
 * @Version 1.0
 **/
public class Client {

    public static void main(String[] args) {
        //1.代理对象对象
        UserServiceImpl userService = new UserServiceImpl();
        //2.代理对象的调用处理程序
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //3.设置要代理的对象
        pih.setTarget(userService);
        //4.动态生成代理类！
        UserService proxy = (UserService)pih.getProxy();
        //5.调用代理类方法，同时会自动的调用被代理类中同名的方法
        proxy.delete();
    }
}