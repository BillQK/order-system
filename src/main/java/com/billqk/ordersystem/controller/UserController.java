package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.UserEntity;
import com.billqk.ordersystem.database.repository.UserRepository;
import com.billqk.ordersystem.model.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/")
    public List<UserDto> getUser() {
        List<UserEntity> userEntityList = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<UserDto>();
        for (UserEntity userEntity : userEntityList) {
            UserDto userDto = new UserDto();
            // Setting attributes
            userDto.setAge(userEntity.getAge());
            userDto.setEmail(userEntity.getEmail());
            userDto.setFirstname(userEntity.getFirst_name());
            userDto.setLastname(userEntity.getLast_name());
            userDto.setMobile(userEntity.getMobile());
            // Adding to list of user
            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser (@Valid @RequestBody UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirst_name(userDto.getFirstname());
        userEntity.setLast_name(userDto.getLastname());
        userEntity.setMobile(userDto.getMobile());
        userEntity.setAge(userDto.getAge());
        userEntity.setEmail(userDto.getEmail());
        userRepository.save(userEntity);
        return "User added";
    }


}
