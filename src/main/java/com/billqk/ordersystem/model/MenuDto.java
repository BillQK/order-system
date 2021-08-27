package com.billqk.ordersystem.model;

import com.billqk.ordersystem.constant.Constant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;


@Getter
@Setter
@NoArgsConstructor
public class MenuDto {
    private Long menuId;
    private String description;
    private boolean status;
    private String menuName;
    private Double price;
    private Constant.Category category;

}
