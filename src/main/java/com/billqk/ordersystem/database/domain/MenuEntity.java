package com.billqk.ordersystem.database.domain;

import com.billqk.ordersystem.constant.Constant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.awt.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
@Table(name = "menus")
@EntityListeners(AuditingEntityListener.class)
public class MenuEntity {

    // variables
    @Id
    @SequenceGenerator(
            name = "menu_sequence",
            sequenceName = "menu_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "menu_sequence"
    )
    @Column(
            name = "menu_id",
            nullable = false,
            updatable = false
    )
    private long menuId;

    @Column(
            name = "menu_name",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String menuName;
    @Column(
            name = "description",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String description;

    @Column(
            name = "price",
            nullable = false
    )
    private Double price;

    @Column(
            name = "status",
            nullable = false
    )

    private boolean status;

    @Column(
            name = "category",
            nullable = false

    )
    @Enumerated(EnumType.STRING)
    private Constant.Category category;


}