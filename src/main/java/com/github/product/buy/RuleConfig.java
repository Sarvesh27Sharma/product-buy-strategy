package com.github.product.buy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class RuleConfig {
    @Bean
    public ColorCondition colorBlueCondition() {
        return ColorCondition.builder().build();
    }

    @Bean
    public QuantityCondition quantityLowCondition() {
        return QuantityCondition.builder().build();
    }

    @Bean
    public PriceCondition priceLowCondition() {
        return PriceCondition.builder().build();
    }

    @Bean
    public Rule rule(ColorCondition colorCondition, PriceCondition priceCondition, QuantityCondition quantityCondition) {
        return Rule.builder()
                .isRulePositive(true)
                .conditions(List.of(colorCondition, priceCondition, quantityCondition))
                .score(1)
                .build();
    }
}
