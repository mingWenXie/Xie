package com.example;

import com.example.constants.FruitConstants;
import com.example.promotion.CompositePromotionStrategy;
import com.example.promotion.DiscountPromotion;
import com.example.promotion.FullReductionPromotion;
import com.example.promotion.PromotionStrategy;
import com.example.shopping.ShoppingCart;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShoppingCartTest {

    @Test
    public void customerA() {
        ShoppingCart cart = new ShoppingCart();
        cart.addFruitByType("Apple", FruitConstants.APPLE_PRICE,1);
        cart.addFruitByType("Strawberry",FruitConstants.STRAWBERRY_PRICE,1);
        double totalPrice = cart.calculateTotalPrice();
        System.out.println("customerA Price: " + totalPrice);
        assertEquals(21, totalPrice);
    }

    @Test
    public void customerB() {
        ShoppingCart cart = new ShoppingCart();
        cart.addFruitByType("Apple",FruitConstants.APPLE_PRICE,1);
        cart.addFruitByType("Strawberry",FruitConstants.STRAWBERRY_PRICE,1);
        cart.addFruitByType("Mango",FruitConstants.MANGO_PRICE,1);
        double totalPrice = cart.calculateTotalPrice();
        System.out.println("customerB Price: " + totalPrice);
        assertEquals(41, totalPrice);
    }

    @Test
    public void customerC() {
        ShoppingCart cart = new ShoppingCart();
        cart.addFruitByType("Apple",FruitConstants.APPLE_PRICE,1);
        cart.addFruitByType("Mango",FruitConstants.MANGO_PRICE,1);
        double totalPrice = cart.calculateTotalPrice();
        ShoppingCart strawberryCart = new ShoppingCart();
        strawberryCart.addFruitByType("Strawberry",FruitConstants.STRAWBERRY_PRICE,1);
        strawberryCart.setPromotionStrategy(new DiscountPromotion());
        double strawberryPrice = strawberryCart.applyPromotion(strawberryCart.calculateTotalPrice());
         totalPrice += strawberryPrice;
        System.out.println("customerC Price: " + totalPrice);
        assertEquals(38.4, totalPrice);
    }

    @Test
    public void customerD() {
        ShoppingCart cart = new ShoppingCart();
        cart.addFruitByType("Apple",FruitConstants.APPLE_PRICE,5);
        cart.addFruitByType("Strawberry",FruitConstants.STRAWBERRY_PRICE,3);
        cart.addFruitByType("Mango",FruitConstants.MANGO_PRICE,2);
        // 创建组合促销策略
        List<PromotionStrategy> strategies = new ArrayList<>();
        strategies.add(new FullReductionPromotion());
        cart.setPromotionStrategy(new CompositePromotionStrategy(strategies));
        double totalPrice = cart.calculateTotalPrice();
        double finalPrice = cart.applyPromotion(totalPrice);
        System.out.println("customerD Price: " + finalPrice);
        assertEquals(109.0, finalPrice);
    }

    @Test
    public void testPromotionBoundaryValues() {
        ShoppingCart cart = new ShoppingCart();
        cart.addFruitByType("Apple",FruitConstants.APPLE_PRICE,12);
        // 创建组合促销策略
        List<PromotionStrategy> strategies = new ArrayList<>();
        strategies.add(new FullReductionPromotion());
        cart.setPromotionStrategy(new CompositePromotionStrategy(strategies));

        double totalPrice = cart.calculateTotalPrice();
        double finalPrice = cart.applyPromotion(totalPrice);
        System.out.println("Apple Price: " + finalPrice);
        assertEquals(96, finalPrice); // 不满100，不减10

        cart.addFruitByType("Strawberry",FruitConstants.STRAWBERRY_PRICE,1);
        totalPrice = cart.calculateTotalPrice();
        finalPrice = cart.applyPromotion(totalPrice);
        System.out.println("Strawberry Price: " + finalPrice);
        assertEquals(99.0, finalPrice); // 满100，减10

        cart.addFruitByType("Mango",FruitConstants.MANGO_PRICE,1);
        totalPrice = cart.calculateTotalPrice();
        finalPrice = cart.applyPromotion(totalPrice);
        System.out.println("Mango Price: " + finalPrice);
        assertEquals(119.0, finalPrice); // 满100，减10
    }
}