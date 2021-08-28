package com.billqk.ordersystem.service;


import lombok.*;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class RegistrationRequest {
    private final String firstName;
    private final String lastName;
    private final String password;
    private final String email;
}
