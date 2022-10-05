package com.banksy.proxy03dynamic;

import com.banksy.proxy03dynamic.service.Impl.Host;
import com.banksy.proxy03dynamic.service.Rent;

/**
 * 客户角色：【使用代理角色来进行一些操作】
 * @Author banksy
 **/
public class Client {

    public static void main(String[] args) {
        //真实角色
        Host host = new Host();
        //代理实例的调用处理程序：
        ProxyInvocationHandler pih = new ProxyInvocationHandler();
        //将真实角色放置进去！【设置要代理的对象】
        pih.setRent(host);
        //动态生成对应的代理类！【获得代理类】
        Rent proxy = (Rent)pih.getProxy();

        proxy.rent();
    }
}
