package com.billqk.ordersystem.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderDetailsDto {
    private long order_details_id;
    private Long orderId;
    private Long menuId;
    private String menuName;
    private double price;
    private int orderQty;
    private double totalPrice;

}
