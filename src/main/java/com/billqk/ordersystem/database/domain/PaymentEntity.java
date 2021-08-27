package com.billqk.ordersystem.database.domain;

import com.billqk.ordersystem.constant.Constant;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.web.bind.annotation.CookieValue;

import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;

import static javax.persistence.GenerationType.SEQUENCE;


@Getter
@Setter
@Entity
@Table(name = "payments")
@EntityListeners(AuditingEntityListener.class)
public class PaymentEntity {

    @Id
    @Column(
            name = "payment_id",
            nullable = false,
            updatable = false
    )
    @SequenceGenerator(
            name = "payment_sequence",
            sequenceName = "payment_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "payment_sequence"
    )
    private Long payment_id;

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            nullable = false,
            updatable = false
    )
    private UserEntity userEntity;

    @OneToOne()
    @JoinColumn(
            name = "order_id",
            nullable = false,
            updatable = false,
            unique = true
    )
    private OrderEntity orderEntity;

    @Column(
            name = "payment_date",
            nullable = false
    )
    private Date paymentDate;

    @Column(
            name = "payment_method"
    )
    @Enumerated(EnumType.STRING)
    private Constant.Payments payment_method;

    public void setPaymentDate() {
        this.paymentDate = Calendar.getInstance().getTime();
    }

}
