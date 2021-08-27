package com.billqk.ordersystem.database.domain;


import com.billqk.ordersystem.constant.Constant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.net.URL;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
    // Primary Key
    @Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "user_sequence"

    )
    @Column(
            name = "user_id",
            updatable = false,
            nullable = false
    )
    private Long user_id;

    @Column(
            name = "first_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String first_name;

    @Column(
            name = "last_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String last_name;

    @Column(
            name = "email",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String email;

    @Column(
            name = "age",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private int age;

    @Column(
            name = "mobile",
            nullable = false,
            columnDefinition = "TEXT",
            unique = true
    )
    private String mobile;
    @Column(
            name = "password",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String password;

    @Column(
            name = "roles",
            nullable = false

    )
    private Constant.Roles role;


}
