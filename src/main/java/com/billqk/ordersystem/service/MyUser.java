package com.billqk.ordersystem.service;

import com.billqk.ordersystem.constant.Constant;
import com.billqk.ordersystem.database.domain.UserEntity;
import com.billqk.ordersystem.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class MyUser implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(s);
        if (userEntity == null) {
            throw new UsernameNotFoundException("Email not found");
        }
        String username = userEntity.getEmail();
        String encodedPassword = new BCryptPasswordEncoder().encode(userEntity.getPassword());
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userEntity.getRole().name()));
        User user = new User(username, encodedPassword, grantedAuthorities);
        return user;
    }

}
