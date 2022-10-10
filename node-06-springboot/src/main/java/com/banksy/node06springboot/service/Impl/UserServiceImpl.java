package com.banksy.node06springboot.service.Impl;

import com.alibaba.fastjson.JSON;
import com.banksy.node06springboot.entity.Dto.UserDto;
import com.banksy.node06springboot.entity.User;
import com.banksy.node06springboot.entity.Vo.UserVo;
import com.banksy.node06springboot.mapper.UserMapper;
import com.banksy.node06springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author banksy
 * @Data 2022/10/10 10:24 PM
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<UserVo> userList() {
        List<User> userList = userMapper.userList();//原始数据
        ArrayList<UserVo> result = new ArrayList<>();//解析Json后的数据

        Iterator iterator = userList.iterator();
        while(iterator.hasNext()){
            Object next = iterator.next();
            System.out.println(next);

            User user = new User();


            String data = user.getData();
            UserDto userData = JSON.parseObject(data, UserDto.class);


            System.out.println(userData);



        }

        return result;
    }
}