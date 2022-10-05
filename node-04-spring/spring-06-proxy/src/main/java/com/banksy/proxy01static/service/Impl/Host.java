package com.banksy.proxy01static.service.Impl;

import com.banksy.proxy01static.service.Rent;

/**
 * 真实角色：【被代理类，真正的实现接口方法，公共操作】
 * @Author banksy
 **/
//房东，房东要出租房子
public class Host implements Rent {

    @Override
    public void rent() {
        System.out.println("房屋出租");
    }
}
