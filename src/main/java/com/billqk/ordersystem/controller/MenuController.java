package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.MenuEntity;
import com.billqk.ordersystem.database.repository.MenuRepository;
import com.billqk.ordersystem.model.MenuDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/menu")
public class MenuController {
    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/")
    public String getMenu() {
        String results = "";
        List<MenuEntity> menuEntityList = menuRepository.findAll();
        for(MenuEntity menuEntity : menuEntityList) {
            results += menuEntity.getId() + " " + menuEntity.getName() + " " + menuEntity.getDescription() + "\n";
        }
        return results;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createMenu(@Valid @RequestBody MenuDto menuDto) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setName(menuDto.getName());
        menuEntity.setDescription(menuDto.getDescription());
        menuRepository.save(menuEntity);
        return "Menu added";
    }
}
