package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.UserEntity;
import com.billqk.ordersystem.database.repository.UserRepository;
import com.billqk.ordersystem.model.UserDto;
import com.billqk.ordersystem.service.EmailSender;
import com.billqk.ordersystem.service.MyUserService;
import com.billqk.ordersystem.service.PasswordResetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;
   @Autowired
    PasswordResetService passwordResetService;

    @GetMapping("")
    public List<UserDto> getUser() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<UserDto>();
        for (UserEntity userEntity : userEntityList) {
            UserDto userDto = new UserDto();
            // Setting attributes
            userDto.setEmail(userEntity.getEmail());
            userDto.setName(userEntity.getFirstName());
            userDto.setUsername(userEntity.getLastName());
            // Adding to list of user
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @PostMapping("/passwordReset")
    public String resetPassword(@RequestParam("email") String email){
        return passwordResetService.resetPassword(email);
    }

    @GetMapping("/confirmPasswordReset")
    public String confirm(@RequestParam("token") String token) {
        passwordResetService.validatePasswordResetToken(token);
        return "Confirmed";

        // TODO: Link the user to the Password Reset Page
    }


}
