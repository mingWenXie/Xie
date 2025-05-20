package com.example.promotion;

public interface PromotionStrategy {
    /**
     * 促销活动
     */
    double applyPromotion(double totalPrice);
}