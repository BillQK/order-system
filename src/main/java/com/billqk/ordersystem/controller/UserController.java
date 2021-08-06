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
            userDto.setId(userEntity.getId());
            userDto.setAge(userEntity.getAge());
            userDto.setEmail(userEntity.getEmail());
            userDto.setFirstname(userEntity.getFirstname());
            userDto.setLastname(userEntity.getFirstname());
            userDto.setMobile(userEntity.getMobile());

            userDtoList.add(userDto);
        }
        return userDtoList;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createUser (@Valid @RequestBody UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setAge(userDto.getAge());
        userEntity.setEmail(userDto.getEmail());
        userEntity.setFirstname(userDto.getFirstname());
        userEntity.setLastname(userDto.getLastname());
        userRepository.save(userEntity);
        return "User added";
    }


}
