package com.banksy.node06springboot.controller;

import com.banksy.node06springboot.dao.Vo.UserVo;
import com.banksy.node06springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author banksy
 * @Data 2022/10/10 10:27 PM
 * @Version 1.0
 **/
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<UserVo> getUserList(){
        return userService.userList();
    }
}