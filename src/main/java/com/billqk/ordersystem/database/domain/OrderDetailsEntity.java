package com.billqk.ordersystem.database.domain;
import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetailsEntity {
    @ManyToOne
    @JoinColumn(
            name = "order_id",
            nullable = false,
            updatable = false
    )
    private OrderEntity orderEntity;

    @ManyToOne
    @JoinColumn(
            name = "menu_id",
            nullable = false,
            updatable = false
    )
    private MenuEntity menuEntity;

    @Column(
            name = "order_Qty",
            nullable = false,
            updatable = false
    )
    private int orderQty;

    @Column (
            name = "total_price",
            nullable = false
    )
    private double totalprice;


    public OrderEntity getOrderEntity() {
        return orderEntity;
    }

    public void setOrderEntity(OrderEntity orderEntity) {
        this.orderEntity = orderEntity;
    }

    public MenuEntity getMenuEntity() {
        return menuEntity;
    }

    public void setMenuEntity(MenuEntity menuEntity) {
        this.menuEntity = menuEntity;
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

    public void setTotalprice(double totalprice) {
        this.totalprice = totalprice;
    }
}



