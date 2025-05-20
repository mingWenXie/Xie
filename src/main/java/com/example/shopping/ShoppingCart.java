package com.example.shopping;

import com.example.factory.FruitFactory;
import com.example.model.Fruit;
import com.example.promotion.PromotionStrategy;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Fruit> fruits;
    private PromotionStrategy promotionStrategy;

    public ShoppingCart() {
        this.fruits = new ArrayList<>();
    }

    public void setPromotionStrategy(PromotionStrategy promotionStrategy) {
        this.promotionStrategy = promotionStrategy;
    }

    public void addFruit(Fruit fruit) {
        fruits.add(fruit);
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        for (Fruit fruit : fruits) {
            totalPrice += fruit.calculatePrice();
        }
        return totalPrice;
    }

    /**
     * 根据注入实例执行不同的优化策略
     */
    public double applyPromotion(double totalPrice) {
        if (this.promotionStrategy != null) {
            return this.promotionStrategy.applyPromotion(totalPrice);
        }
        return totalPrice;
    }
    // 新增方法：支持动态添加水果
    public void addFruitByType(String fruitName,int price, int quantity) {
       Fruit fruit = FruitFactory.createFruit(fruitName,price,quantity);
       if(fruit!=null){
           fruits.add(fruit);
       }
    }

    // 新增方法：获取购物车中的水果列表
    public List<Fruit> getFruits() {
        return new ArrayList<>(fruits);
    }
}