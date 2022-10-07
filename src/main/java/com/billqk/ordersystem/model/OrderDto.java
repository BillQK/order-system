package com.billqk.ordersystem.model;


import com.billqk.ordersystem.constant.Constant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private Long orderId;
    private Long userId;
    private String userName;
    private Date orderDate;
    private Constant.Status status;
    private Double totalPrice;
    private List<OrderDetailsDto> orderDetailsDtoList;


}
