package com.banksy.node06springboot.mapper;

import com.banksy.node06springboot.dao.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> userList();
}
