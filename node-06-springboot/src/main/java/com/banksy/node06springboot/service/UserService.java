package com.banksy.node06springboot.service;

import com.banksy.node06springboot.entity.Vo.UserVo;

import java.util.List;

public interface UserService {

    List<UserVo> userList();
}
