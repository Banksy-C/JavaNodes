package com.banksy.node06springboot.service;

import com.banksy.node06springboot.dao.Vo.UserVo;

import java.util.List;

public interface UserService {

    List<UserVo> userList();
}
