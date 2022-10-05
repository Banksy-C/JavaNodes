package com.banksy.proxy02static;

import com.banksy.proxy02static.service.Impl.UserServiceImpl;
import com.banksy.proxy02static.service.UserService;

/**
 * 代理角色：【代理类 ; 代理真实角色后, 一般会做一些附属的操作】
 * @Author banksy
 **/
public class UserServiceProxy implements UserService {
    private UserServiceImpl userService;


    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Override
    public void add() {
        log("add");
        userService.add();
    }

    @Override
    public void delete() {
        log("delete");
        userService.delete();
    }

    @Override
    public void update() {
        log("update");
        userService.update();
    }

    @Override
    public void query() {
        log("query");
        userService.query();
    }

    public void log(String msg){
        System.out.println("执行了"+msg+"方法");
    }

}
