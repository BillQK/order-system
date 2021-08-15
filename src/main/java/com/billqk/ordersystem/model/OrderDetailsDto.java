package com.billqk.ordersystem.model;

public class OrderDetailsDto {
    private long order_details_id;
    private Long orderId;
    private Long menuId;
    private int orderQty;
    private double totalprice;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public int getOrderQty() {
        return orderQty;
    }

    public void setOrderQty(int orderQty) {
        this.orderQty = orderQty;
    }

    public double getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(double totalPrice) {
        this.totalprice = totalprice;
    }
    public long getOrder_details_id() {
        return order_details_id;
    }

    public void setOrder_details_id(long order_details_id) {
        this.order_details_id = order_details_id;
    }
}
