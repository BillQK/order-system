package com.billqk.ordersystem.database.domain;

import com.billqk.ordersystem.constant.Constant;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
@Entity
@Table(name = "menu")
@EntityListeners(AuditingEntityListener.class)
public class MenuEntity {

    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;
    private String description;
    private Double price;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Constant.Category category;

    //getter and setter
    public Constant.Category getCategory() {
        return category;
    }

    public void setCategory(Constant.Category category) {
        this.category = category;
    }



    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription (String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}