package com.billqk.ordersystem.model;

public class OrderDetailsDto {
    private long order_details_id;
    private Long orderId;
    private Long menuId;
    private String menuName;
    private double price;
    private int orderQty;
    private double totalprice;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Long getOrderId() {
        return orderId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
        this.totalprice = totalPrice;
    }
    public long getOrder_details_id() {
        return order_details_id;
    }

    public void setOrder_details_id(long order_details_id) {
        this.order_details_id = order_details_id;
    }
}
