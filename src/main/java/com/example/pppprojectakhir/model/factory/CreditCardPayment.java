package com.example.pppprojectakhir.model.factory;

public class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Sukses bayar sejumlah " + amount + " dengan kartu kredit.");
    }
}