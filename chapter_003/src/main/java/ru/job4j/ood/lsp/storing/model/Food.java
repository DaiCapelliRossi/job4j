package ru.job4j.ood.lsp.storing.model;

import java.util.Calendar;
import java.util.Objects;

public class Food {
    private String name;
    private Calendar createDate;
    private Calendar expiryDate;
    private double price;
    private double discount;
    private boolean onSale;

    public Food(String name, Calendar createDate, Calendar expiryDate, double price, double discount) {
        this.name = name;
        this.createDate = createDate;
        this.expiryDate = expiryDate;
        this.price = price;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Calendar getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Calendar createDate) {
        this.createDate = createDate;
    }

    public Calendar getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Calendar expiryDate) {
        this.expiryDate = expiryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public boolean isOnSale() {
        return onSale;
    }

    public void setOnSale() {
        this.onSale = !onSale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Food food = (Food) o;
        return Double.compare(food.price, price) == 0 && discount == food.discount && Objects.equals(name, food.name) && Objects.equals(createDate, food.createDate) && Objects.equals(expiryDate, food.expiryDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, expiryDate, price, discount);
    }
}
