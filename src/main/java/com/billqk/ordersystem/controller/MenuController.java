package com.billqk.ordersystem.controller;

import com.billqk.ordersystem.database.domain.MenuEntity;
import com.billqk.ordersystem.database.repository.MenuRepository;
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
            results += menuEntity.getId() + " " + menuEntity.getName() + "\n";
        }
        return results;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public String createMenu(@Valid @RequestBody String menuName) {
        MenuEntity menuEntity = new MenuEntity();
        menuEntity.setName(menuName);
        menuEntity = menuRepository.save(menuEntity);
        return "Menu added";
    }
}
