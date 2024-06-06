package com.example.pppprojectakhir.model.factory;

public class CashPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Sukses bayar sejumlah " + amount + " secara langsung.");
    }
}
