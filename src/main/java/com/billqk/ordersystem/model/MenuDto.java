package com.billqk.ordersystem.model;

import com.billqk.ordersystem.constant.Constant;


import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class MenuDto {
    private Long menuId;
    private String description;
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    private String menuName;
    private Double price;

    public Constant.Category getCategory() {
        return category;
    }

    public void setCategory(Constant.Category category) {
        this.category = category;
    }

    private Constant.Category category;

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
