package com.billqk.ordersystem.model;

public class MenuDto {
    private Long id;
    private String description;
    private String name;

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
