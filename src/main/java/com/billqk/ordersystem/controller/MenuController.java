package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.MenuEntity;
import com.billqk.ordersystem.database.domain.UserEntity;
import com.billqk.ordersystem.database.repository.MenuRepository;
import com.billqk.ordersystem.database.repository.UserRepository;
import com.billqk.ordersystem.model.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/")
    public List<MenuDto> getMenu() {

        List<MenuEntity> menuEntityList = menuRepository.findAll();

        List<MenuDto> menuDtoList = new ArrayList<MenuDto>();
        for (MenuEntity menuEntity : menuEntityList) {
            // MenuDto
            MenuDto menuDto = new MenuDto();
            // Setting attribute
            menuDto.setMenuId(menuEntity.getMenuId());
            menuDto.setMenuName(menuEntity.getMenuName());
            menuDto.setStatus(menuEntity.isStatus());
            menuDto.setCategory(menuEntity.getCategory());
            menuDto.setPrice(menuEntity.getPrice());
            menuDto.setDescription(menuEntity.getDescription());
            // Adding to list
            menuDtoList.add(menuDto);
        }
        return menuDtoList;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createMenu(@Valid @RequestBody MenuDto menuDto) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setMenuName(menuDto.getMenuName());
        menuEntity.setDescription(menuDto.getDescription());
        menuEntity.setCategory(menuDto.getCategory());
        menuEntity.setPrice(menuDto.getPrice());
        menuEntity.setStatus(menuDto.isStatus());
        menuRepository.save(menuEntity);

        return "Menu added";
    }

}
