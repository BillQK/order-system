package com.billqk.ordersystem.model;

import com.billqk.ordersystem.constant.Constant;

import java.util.Calendar;
import java.util.Date;

public class PaymentDto {
    private Long payment_id;
    private Long order_id;
    private Long user_id;
    private Date payment_Date;
    private Constant.Payments payment_method;

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Date getPayment_Date() {
        return payment_Date;
    }

    public void setPayment_Date(Date payment_Date) {
        this.payment_Date = payment_Date;
    }

    public Constant.Payments getPayment_method() {
        return payment_method;
    }

    public void setPayment_method(Constant.Payments payment_method) {
        this.payment_method = payment_method;
    }
}
