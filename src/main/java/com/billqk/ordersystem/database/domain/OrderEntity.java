package com.billqk.ordersystem.database.domain;

import javax.persistence.*;


public class OrderEntity {

    // variables
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_Id", nullable = false)
    private UserEntity userEntity;

    private MenuEntity menuEntity;
}
