package com.example.factory;

import com.example.model.*;

/**
 * 水果工厂，校验并创建水果类型
 */
public class FruitFactory {
    public static Fruit createFruit(String fruitName,int price, int quantity) {
        if (fruitName == null || fruitName.isEmpty() || quantity <= 0 || price <= 0) {
            return null;
        }
        return new Fruit(fruitName,price,quantity);
    }
}