package com.github.product.buy;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class PriceCondition implements Condition {

    private static final BigDecimal LOW_COST = BigDecimal.valueOf(17.75); //TODO: make it parameterised

    @Override
    public boolean isConditionFulFilled(final Product product) {
        return product.getCost().compareTo(LOW_COST) < 0;
    }
}
