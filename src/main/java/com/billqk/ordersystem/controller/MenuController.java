package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.MenuEntity;
import com.billqk.ordersystem.database.repository.MenuRepository;
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
    public List<MenuDto>  getMenu() {

        List<MenuEntity> menuEntityList = menuRepository.findAll();
        List<MenuDto> menuDtosList = new ArrayList<MenuDto>();
        for(MenuEntity menuEntity : menuEntityList) {
            MenuDto menuDto = new MenuDto();
            menuDto.setId(menuEntity.getId());
            menuDto.setName(menuEntity.getName());
            menuDto.setDescription(menuEntity.getDescription());
            menuDto.setPrice(menuEntity.getPrice());
            menuDto.setCategory(menuEntity.getCategory());

            menuDtosList.add(menuDto);
        }
        return menuDtosList;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createMenu(@Valid @RequestBody MenuDto menuDto) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setName(menuDto.getName());
        menuEntity.setDescription(menuDto.getDescription());
        menuEntity.setCategory(menuDto.getCategory());
        menuRepository.save(menuEntity);
        return "Menu added";
    }

}
