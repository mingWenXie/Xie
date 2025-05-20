package com.example.promotion;

import com.example.constants.FruitConstants;

/**
 * 打8折优惠策略
 */
public class DiscountPromotion implements PromotionStrategy {
    @Override
    public double applyPromotion(double totalPrice) {
        return totalPrice * FruitConstants.STRAWBERRY_DISCOUNT;
    }
}