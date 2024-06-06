package com.example.pppprojectakhir.controller;

import com.example.pppprojectakhir.model.*;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class HelloController implements Observer {
    @FXML
    private ComboBox<String> itemComboBox;

    @FXML
    private TextField itemPriceField;

    @FXML
    private ListView<String> cartListView;

    @FXML
    private ComboBox<String> discountComboBox;

    private final Cart cart = new Cart();

    private final Map<String, Double> itemPrices = new HashMap<>();

    @FXML
    public void initialize() {
        cart.registerObserver(this);

        // Initialize item prices
        itemPrices.put("Nasi Uduk", 7000.0);
        itemPrices.put("Nasi Ayam Bakar", 11000.0);
        itemPrices.put("Nasi Rawon", 10000.0);
        itemPrices.put("Soto Ayam", 12000.0);
        itemPrices.put("Soto Babat", 10000.0);
        itemPrices.put("Nasi goreng", 12000.0);
        itemPrices.put("Sate Ayam", 15000.0);
        itemPrices.put("Sate Kambing", 17000.0);
        itemPrices.put("Gule Kambing", 20000.0);
        itemPrices.put("Nasi Campur", 12000.0);
        itemPrices.put("Es Teh", 5000.0);
        itemPrices.put("Es Jeruk", 5000.0);
        itemPrices.put("Kopi Hitam", 3000.0);
        itemPrices.put("Air Putih", 0.0);

        // Set ComboBox items and listener
        itemComboBox.setItems(FXCollections.observableArrayList(itemPrices.keySet()));
        itemComboBox.setOnAction(e -> updateItemPrice());
    }

    @FXML
    private void updateItemPrice() {
        String selectedItem = itemComboBox.getValue();
        if (selectedItem != null) {
            double price = itemPrices.get(selectedItem);
            itemPriceField.setText(String.valueOf(price));
        }
    }

    @FXML
    public void addItem() {
        String name = itemComboBox.getValue();
        double price = Double.parseDouble(itemPriceField.getText());
        Item item = new Item(name, price);
        cart.addItem(item);
        itemComboBox.setValue(null);
        itemPriceField.clear();
    }

    @FXML
    public void applyDiscount() {
        String selectedDiscount = discountComboBox.getValue();
        if (selectedDiscount != null) {
            switch (selectedDiscount) {
                case "Diskon 10%":
                    cart.setDiscountStrategy(new PercentageDiscount(10));
                    break;
                case "Diskon 5%":
                    cart.setDiscountStrategy(new FixedAmountDiscount(5));
                    break;
                default:
                    cart.setDiscountStrategy(null);
                    break;
            }
        }
        update();
    }

    @FXML
    public void payWithCash() {
        processPayment("cash");
    }

    @FXML
    public void payWithCreditCard() {
        processPayment("credit_card");
    }

    private void processPayment(String paymentType) {
        double totalAmount = cart.getTotalPrice();
        PaymentMethod paymentMethod = PaymentMethodFactory.createPaymentMethod(paymentType);
        paymentMethod.pay(totalAmount);
        cart.getItems().clear();
        cart.setDiscountStrategy(null);
        update();
    }

    @Override
    public void update() {
        cartListView.getItems().clear();
        for (Item item : cart.getItems()) {
            cartListView.getItems().add(item.getName() + " - Rp " + item.getPrice());
        }
        if (cart.getTotalPrice() > 0) {
            cartListView.getItems().add("Total: Rp " + cart.getTotalPrice());
        }
    }
}