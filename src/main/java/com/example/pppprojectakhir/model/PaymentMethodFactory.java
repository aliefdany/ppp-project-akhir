package com.example.pppprojectakhir.model;

public class PaymentMethodFactory {
    public static PaymentMethod createPaymentMethod(String type) {
        switch (type) {
            case "cash":
                return new CashPayment();
            case "credit_card":
                return new CreditCardPayment();
            default:
                throw new IllegalArgumentException("Unknown payment method type");
        }
    }
}