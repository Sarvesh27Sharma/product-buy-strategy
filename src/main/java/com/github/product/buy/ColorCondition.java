package com.github.product.buy;

import lombok.Builder;

@Builder
public class ColorCondition implements Condition {

    private static final String COLOR = "BLUE"; //TODO: make it parameterised

    @Override
    public boolean isConditionFulFilled(final Product product) {
        return product.getColor().equalsIgnoreCase(COLOR);
    }
}
