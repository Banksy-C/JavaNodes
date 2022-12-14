package com.banksy.node06springboot.dao.Dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author banksy
 * @Data 2022/10/10 10:54 PM
 * @Version 1.0
 **/
@Data
public class UserDto implements Serializable {
    private String phone;
    private String address;
    private String minzu;
}