package com.billqk.ordersystem.database.domain;

import com.billqk.ordersystem.constant.Constant;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.awt.*;

import static javax.persistence.GenerationType.SEQUENCE;


@Entity
@Table(name = "menus")
@EntityListeners(AuditingEntityListener.class)
public class MenuEntity {

    // variables
    @Id
    @SequenceGenerator(
            name = "menu_sequence",
            sequenceName = "menu_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "menu_sequence"
    )
    @Column(
            name = "menu_id",
            nullable = false,
            updatable = false
    )
    private long menuId;

    @Column(
            name = "menu_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String menuName;
    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "price",
            nullable = false
    )
    private Double price;

    @Column(
            name = "status",
            nullable = false
    )

    private boolean status;

    @Column(
            name = "category",
            nullable = false

    )
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

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "MenuEntity{" +
                "menuId=" + menuId +
                ", menuName='" + menuName + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", status=" + status +
                ", category=" + category +
                '}';
    }
}