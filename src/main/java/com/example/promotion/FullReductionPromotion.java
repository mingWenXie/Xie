package com.example.promotion;

import com.example.constants.FruitConstants;

/**
 * 满100减10优惠策略
 */
public class FullReductionPromotion implements PromotionStrategy {
    @Override
    public double applyPromotion(double totalPrice) {
        if (totalPrice >= FruitConstants.PROMOTION_THRESHOLD) {
            return totalPrice - FruitConstants.PROMOTION_DISCOUNT;
        }
        return totalPrice;
    }
}