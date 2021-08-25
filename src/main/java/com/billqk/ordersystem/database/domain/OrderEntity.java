package com.billqk.ordersystem.database.domain;

import com.billqk.ordersystem.constant.Constant;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

import java.util.Date;

import java.util.Calendar;

import static javax.persistence.GenerationType.SEQUENCE;

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

    @Column(
            name = "status",
            nullable = false,
            columnDefinition = "TEXT"
    )
    private Constant.Status status;

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate() {
        this.orderDate = Calendar.getInstance().getTime();
    }

    public Constant.Status getStatus() {
        return status;
    }

    public void setStatus(Constant.Status status) {
        this.status = status;
    }
}
