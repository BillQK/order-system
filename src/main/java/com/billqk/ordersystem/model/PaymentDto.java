package com.billqk.ordersystem.model;

import com.billqk.ordersystem.constant.Constant;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;

@Getter
@Setter
public class PaymentDto {
    private Long payment_id;
    private Long order_id;
    private Long user_id;
    private Date payment_Date;
    private Constant.Payments payment_method;

    public void setPayment_Date() {
        this.payment_Date = Calendar.getInstance().getTime();
    }

}
