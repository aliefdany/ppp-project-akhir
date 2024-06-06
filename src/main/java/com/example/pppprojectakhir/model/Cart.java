package com.example.pppprojectakhir.model;

import java.util.ArrayList;
import java.util.List;

public class Cart extends Subject {
    private final List<Item> items = new ArrayList<>();
    private DiscountStrategy discountStrategy;

    public void addItem(Item item) {
        items.add(item);
        notifyObservers();
    }

    public void removeItem(Item item) {
        items.remove(item);
        notifyObservers();
    }

    public List<Item> getItems() {
        return items;
    }

    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
        notifyObservers();
    }

    public double getTotalPrice() {
        double total = items.stream().mapToDouble(Item::getPrice).sum();
        if (discountStrategy != null) {
            total = discountStrategy.applyDiscount(total);
        }
        return total;
    }
}