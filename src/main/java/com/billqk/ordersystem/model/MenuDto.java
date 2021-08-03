package com.billqk.ordersystem.model;

import com.billqk.ordersystem.constant.Constant;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;



public class MenuDto {
    private Long id;
    private String description;
    private String name;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

}
