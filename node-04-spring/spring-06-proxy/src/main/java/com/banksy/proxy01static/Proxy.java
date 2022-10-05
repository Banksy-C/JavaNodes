package com.banksy.proxy01static;

import com.banksy.proxy01static.service.Impl.Host;
import com.banksy.proxy01static.service.Rent;

/**
 * 代理角色：【代理类 ; 代理真实角色后, 一般会做一些附属的操作】
 * @Author banksy
 **/
//代理角色：中介
public class Proxy implements Rent {
    private Host host;

    //租房
    @Override
    public void rent() {
        seeHouse();
        host.rent();
        fare();
    }

    public Proxy() {
    }
    public Proxy(Host host) {
        this.host = host;
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
