package edu.hillel.nikolenko.homeworks.homework14_stream;

import java.time.LocalDate;

public class Product {
    private String type;
    private double price;
    private boolean applyDiscount;
    private LocalDate addingDate = LocalDate.now();

    public Product(String type, double price, boolean applyDiscount) {
        this.type = type;
        this.price = price;
        this.applyDiscount = applyDiscount;
    }

    public Product(String type, double price, boolean applyDiscount, String addingDate) {
        this.type = type;
        this.price = price;
        this.applyDiscount = applyDiscount;
        this.addingDate = LocalDate.parse(addingDate);
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isApplyDiscount() {
        return applyDiscount;
    }

    public LocalDate getAddingDate() {
        return addingDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", applyDiscount=" + applyDiscount +
                ", addingDate=" + addingDate +
                '}';
    }
}
