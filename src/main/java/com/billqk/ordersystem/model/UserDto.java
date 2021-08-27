package com.billqk.ordersystem.model;

import com.billqk.ordersystem.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.net.URL;


@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private Long id;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private int age;
    private String mobile;

}
