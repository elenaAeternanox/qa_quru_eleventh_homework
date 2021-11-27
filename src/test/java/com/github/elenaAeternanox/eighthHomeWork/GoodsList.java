package com.github.elenaAeternanox.eighthHomeWork;

public enum GoodsList {
    MILK("milk", 50.4),
    SUGAR("sugar", 45.6),
    CHEESE("cheese", 89.4);

    private String title;
    private double price;

    GoodsList(String title, double price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }
}
