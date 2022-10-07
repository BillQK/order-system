package com.billqk.ordersystem.service;

import com.billqk.ordersystem.database.domain.ConfirmationToken;
import com.billqk.ordersystem.database.domain.UserEntity;
import com.billqk.ordersystem.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service

public class MyUserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ConfirmationTokenService confirmationTokenService;

    @Autowired
    EmailService emailService;

    @Autowired
    RegistrationService registrationService;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s).orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, s))
        );

    }

    public String signUpUser(UserEntity userEntity) {
        boolean userExists = userRepository.findByEmail(userEntity.getEmail())
                .isPresent();

        String token = UUID.randomUUID().toString();

        if (userExists) {
            UserEntity user = userRepository.findByEmail(userEntity.getEmail()).orElseThrow(
                    () -> new UsernameNotFoundException("Email not found")
            );
            // TODO check of attributes are the same and
            // TODO if email not confirmed send confirmation email.
            if (!user.isEnabled()) {
                String link = "http://localhost:5000/api/registration?token=" + token;

                emailService.send(user.getEmail(),
                        registrationService.buildEmail(user.getFirstName(), link));

                ConfirmationToken confirmationToken = new ConfirmationToken(
                        token,
                        LocalDateTime.now(),
                        LocalDateTime.now().plusMinutes(15),
                        user
                );

                confirmationTokenService.saveConfirmationToken(confirmationToken);
                return "Email confirmation has been resent";
            }
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(userEntity.getPassword());

        userEntity.setPassword(encodedPassword);

        userRepository.save(userEntity);


        ConfirmationToken confirmationToken = new ConfirmationToken(
                token,
                LocalDateTime.now(),
                LocalDateTime.now().plusMinutes(15),
                userEntity
        );

        confirmationTokenService.saveConfirmationToken(confirmationToken);
        return token;

        // TODO : SEND EMAIL
    }


    public int enableUserEntity(String email) {
        return userRepository.enableUserEntity(email);
    }
}
