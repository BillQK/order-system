package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.constant.Constant;
import com.billqk.ordersystem.database.domain.UserEntity;
import com.billqk.ordersystem.database.repository.UserRepository;
import com.billqk.ordersystem.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/user")
public class UserController {
    @Autowired
    UserRepository userRepository;

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


}
