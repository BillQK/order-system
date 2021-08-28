package com.billqk.ordersystem.service;

import com.billqk.ordersystem.database.domain.UserEntity;
import com.billqk.ordersystem.database.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service

public class MyUserService implements UserDetailsService {
    private final static String USER_NOT_FOUND_MSG =
            "user with email %s not found";

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByEmail(s).orElseThrow(
                () -> new UsernameNotFoundException(
                        String.format(USER_NOT_FOUND_MSG, s))
        );

    }

    public String signUpUser(UserEntity userEntity) {
        boolean userExists = userRepository.findByEmail(userEntity.getEmail())
                .isPresent();

        if (userExists) {
            throw new IllegalStateException("email already taken");
        }

        String encodedPassword = bCryptPasswordEncoder.encode(userEntity.getPassword());

        userEntity.setPassword(encodedPassword);

        userRepository.save(userEntity);

        // TODO: Send confirmation token
        return "User added";
    }


}
