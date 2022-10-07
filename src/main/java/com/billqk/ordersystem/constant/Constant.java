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
        IN_QUEUE, RECEIVED, READY, IN_DELIVERY, DELIVERED
    }
}
