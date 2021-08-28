package com.billqk.ordersystem.service;

import com.billqk.ordersystem.constant.Constant;
import com.billqk.ordersystem.database.domain.UserEntity;
import com.billqk.ordersystem.service.token.ConfirmationToken;
import com.billqk.ordersystem.service.token.ConfirmationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class RegistrationService {
    @Autowired
    MyUserService myUserService;

    @Autowired
    EmailValidator emailValidator;

    @Autowired
    ConfirmationTokenService confirmationTokenService;


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

    public String registerAdmin(RegistrationRequest request) {
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
                        Constant.Roles.ADMIN

                )
        );
    }

    @Transactional
    public String confirmToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token)
                .orElseThrow(
                        () -> new IllegalStateException("Token Not Found")
                );
        if (confirmationToken.getConfirmedAt() != null) {
            throw new IllegalStateException("Email Already confirmed");

        }
        LocalDateTime expiredAt = confirmationToken.getExpiredAt();
        if (expiredAt.isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Token Expired");
        }

        confirmationTokenService.setConfirmAt(token);
        myUserService.enableUserEntity(
                confirmationToken.getUserEntity().getEmail()
        );
        return "Confirmed";
    }


}
