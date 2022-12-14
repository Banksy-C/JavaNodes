package com.banksy.node06springboot.service.Impl;

import com.alibaba.fastjson.JSON;
import com.banksy.node06springboot.dao.Dto.UserDto;
import com.banksy.node06springboot.dao.entity.User;
import com.banksy.node06springboot.dao.Vo.UserVo;
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

        Iterator<User> iterator = userList.iterator();
        while(iterator.hasNext()){
            User next = iterator.next();//遍历源的下一个元素
            UserVo userVo = new UserVo();//结果对象

            UserDto userData = JSON.parseObject(next.getData(), UserDto.class);
            userVo.setId(next.getId());
            userVo.setName(next.getName());
            userVo.setAge(next.getAge());
            userVo.setSex(next.getSex());
            userVo.setPhone(userData.getPhone());
            userVo.setAddress(userData.getAddress());
            userVo.setMinzu(userData.getMinzu());

            result.add(userVo);//结果对象放进list中


        }

        return result;
    }
}