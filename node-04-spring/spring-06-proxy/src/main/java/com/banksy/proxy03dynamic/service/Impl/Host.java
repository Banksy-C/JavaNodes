package com.banksy.proxy03dynamic.service.Impl;

import com.banksy.proxy03dynamic.service.Rent;

/**
 * 真实角色：【被代理类，真正的实现接口方法，公共操作】
 * @Author banksy
 **/
public class Host implements Rent {
    @Override
    public void rent() {
        System.out.println("房屋出租");
    }
}
