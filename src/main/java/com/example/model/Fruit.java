package com.example.model;

/**
 * 对象水果
 */
public class Fruit {
    protected String fruitName;
    protected int price;
    protected int quantity;

    public Fruit(String fruitName,int price, int quantity) {
        this.fruitName = fruitName;
        this.price = price;
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
    
    public String getFruitName() {
        return fruitName;
    }

    public double calculatePrice() {
        return price * quantity;
    }
}