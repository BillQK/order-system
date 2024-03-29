package com.billqk.ordersystem.constant;

public class Constant {
    public enum Category {
        ASIAN, EUROPEAN, AMERICAN, INDIAN, AFRICAN, MEXICAN
    }

    public enum Payments {
        VISA, MASTERCARD, PAYPAL
    }

    public enum Roles {
        ADMIN, USER
    }

    public enum Status {
        RECEIVED, PREPARING, READY, IN_DELIVERY, DELIVERED
    }
}
