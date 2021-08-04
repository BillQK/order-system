package com.billqk.ordersystem.database.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.net.URL;

@Entity
@Table(name = "/user")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    private String firstname;
    private String lastname;
    private URL email;
    private int age;




}
