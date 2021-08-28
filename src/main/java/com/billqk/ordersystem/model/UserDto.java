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
    private String name;
    private String username;
    private String email;
    private String password;

}
