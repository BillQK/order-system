package com.billqk.ordersystem.service;

import com.billqk.ordersystem.database.domain.ConfirmationToken;
import com.billqk.ordersystem.database.domain.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class PasswordResetService {

    @Autowired
    EmailValidator emailValidator;

    @Autowired
    UserEntity userEntity;

    @Autowired
    MyUserService myUserService;

    @Autowired
    ConfirmationTokenService confirmationTokenService;
    
    public String resetPassword(String email) {
        boolean emailValid = emailValidator.test(email);
        if (!emailValid) {
            throw new IllegalStateException("Email not valid");
        }

        String token = myUserService.createPasswordResetTokenForUser(userEntity);
        return token;
    }

    @Transactional
    public String validatePasswordResetToken(String token) {
        ConfirmationToken confirmationToken = confirmationTokenService.getToken(token).orElseThrow(
                () -> new IllegalStateException("Token Not Found")
        );
        LocalDateTime expiredAt = confirmationToken.getExpiredAt();
        if (expiredAt.isBefore((LocalDateTime.now())))
        {
            throw  new IllegalStateException("Token Expired");
        }
        confirmationTokenService.setConfirmAt(token);
        return "Password Reset";

        // TODO : Redirect the user to an reset password page.
    }

    // TODO: Build Email & Implement USER Change Password API
}
