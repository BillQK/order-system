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
    @Column(name = "menu_Id", nullable = false, updatable = false)
    private long menuId;

    @Column(nullable = false)
    private String menuName;
    private String description;
    private Double price;
    private boolean status;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Constant.Category category;


    //getter and setter

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
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

    public String getDescription() {
        return description;
    }

    public void setDescription (String description) {
        this.description = description;
    }

}