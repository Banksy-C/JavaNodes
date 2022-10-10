package com.banksy.node06springboot.entity;

import lombok.Data;

/**
 * @Author banksy
 * @Data 2022/10/10 10:02 PM
 * @Version 1.0
 **/
@Data
public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private String data;
}