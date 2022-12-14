package com.banksy.node06springboot.dao.Vo;

import lombok.Data;

/**
 * @Author banksy
 * @Data 2022/10/10 10:46 PM
 * @Version 1.0
 **/
@Data
public class UserVo {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String phone;
    private String address;
    private String minzu;
}