package com.banksy.proxy02static.service.Impl;

import com.banksy.proxy02static.service.UserService;

/**
 * 真实角色：【被代理类，真正的实现接口方法，公共操作】
 * @Author banksy
 **/
public class UserServiceImpl implements UserService {

    @Override
    public void add() {
        System.out.println("增加了一个用户");
    }

    @Override
    public void delete() {
        System.out.println("删除了一个用户");
    }

    @Override
    public void update() {
        System.out.println("更新了一个用户");
    }

    @Override
    public void query() {
        System.out.println("查询了一个用户");
    }
}
