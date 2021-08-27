package com.billqk.ordersystem.database.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;


@Getter
@Setter
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

    @Column(
            name = "total_price",
            nullable = false
    )
    private double totalPrice;


}



