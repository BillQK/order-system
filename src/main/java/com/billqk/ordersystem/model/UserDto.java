package com.billqk.ordersystem.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class UserDto {
    private String name;
    private String username;
    private String email;
    private String password;

}
