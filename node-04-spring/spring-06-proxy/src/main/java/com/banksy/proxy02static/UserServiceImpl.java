package com.banksy.proxy02static;

/**
 * 【实现类】
 * @Author banksy
 * @Date 2022/10/4 10:17 AM
 * @Param
 * @return
 **/
public class UserServiceImpl implements UserService{

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
