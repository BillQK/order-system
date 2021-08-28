package com.billqk.ordersystem.service;

import com.billqk.ordersystem.constant.Constant;
import com.billqk.ordersystem.database.domain.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class RegistrationService {
    @Autowired
    MyUserService myUserService;

    @Autowired
    EmailValidator emailValidator;


    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());
        if (!isValidEmail) {
            throw new IllegalStateException("email not valid");
        }
        return myUserService.signUpUser(
                new UserEntity(
                        request.getFirstName(),
                        request.getLastName(),
                        request.getEmail(),
                        request.getPassword(),
                        Constant.Roles.USER

                )
        );
    }
}
