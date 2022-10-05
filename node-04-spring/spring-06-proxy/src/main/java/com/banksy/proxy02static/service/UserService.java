package com.banksy.proxy02static.service;

/**
 * 抽象角色：【一般使用接口或者抽象类来实现】
 * @Author banksy
 **/
//抽象角色：增删改查业务
public interface UserService {
    void add();
    void delete();
    void update();
    void query();
}
