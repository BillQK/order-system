package com.billqk.ordersystem.model;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
}
