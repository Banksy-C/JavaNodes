package com.banksy.proxy02static;

/**
 * 【代理】
 * @Author banksy
 * @Date 2022/10/4 10:17 AM
 * @Param
 * @return
 **/
public class UserServiceProxy implements UserService{
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
