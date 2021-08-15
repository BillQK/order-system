package com.billqk.ordersystem.model;


import java.util.Date;
import java.util.List;

public class OrderDto {
    private Long orderId;
    private Long userId;
    private String userName;
    private Date orderDate;
    private String status;
    private Double totalPrice;
    private List<OrderDetailsDto> orderDetailsDtoList;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderDetailsDto> getOrderDetailsDtoList() {
        return orderDetailsDtoList;
    }

    public void setOrderDetailsDtoList(List<OrderDetailsDto> orderDetailsDtoList) {
        this.orderDetailsDtoList = orderDetailsDtoList;
    }
}
