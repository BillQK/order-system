package com.billqk.ordersystem.model;

import com.billqk.ordersystem.constant.Constant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
