package com.billqk.ordersystem.database.domain;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "order_details")
@EntityListeners(AuditingEntityListener.class)
public class OrderDetailsEntity {


    @Id
    @SequenceGenerator(
            name = "order_details_id_generator",
            sequenceName = "order_details_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_details_id_generator"
    )
    @Column(
            name = "order_details_id",
            nullable = false,
            updatable = false
    )
    private Long order_details_id;

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
    private double totalPrice;


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

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getOrder_details_id() {
        return order_details_id;
    }

    public void setOrder_details_id(Long order_details_id) {
        this.order_details_id = order_details_id;
    }


}



