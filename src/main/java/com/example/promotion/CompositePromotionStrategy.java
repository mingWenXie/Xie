package com.example.promotion;

import java.util.List;

/**
 * 组合策略，实现多优惠策略，可以根据不同需求新增不同的适配器
 */
public class CompositePromotionStrategy implements PromotionStrategy {
    private List<PromotionStrategy> strategies;

    public CompositePromotionStrategy(List<PromotionStrategy> strategies) {
        this.strategies = strategies;
    }

    @Override
    public double applyPromotion(double totalPrice) {
        for (PromotionStrategy strategy : strategies) {
            totalPrice = strategy.applyPromotion(totalPrice);
        }
        return totalPrice;
    }
}