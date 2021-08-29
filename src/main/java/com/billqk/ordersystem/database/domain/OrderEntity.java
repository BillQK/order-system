package com.billqk.ordersystem.database.domain;

import com.billqk.ordersystem.constant.Constant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;


@Getter
@Setter
@Entity
@Table(name = "orders")
@EntityListeners(AuditingEntityListener.class)
public class OrderEntity {

    // variables
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "order_sequence"
    )
    @Column(
            name = "order_id",
            updatable = false,
            nullable = false
    )
    private Long order_id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            columnDefinition = "INTEGER"
    )
    private UserEntity userEntity;

    @Column(
            name = "order_date",
            nullable = false,
            columnDefinition = "TIME"
    )
    private Date orderDate;

    @Enumerated(EnumType.STRING)
    @Column(
            name = "status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Constant.Status status;


    public void setOrderDate() {
        this.orderDate = Calendar.getInstance().getTime();
    }


}
