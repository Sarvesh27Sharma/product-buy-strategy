package com.github.product.buy;

import lombok.Builder;

//TODO: correct it
@Builder
public class QuantityCondition implements Condition {

    private static final int QUANTITY = 750; //TODO: make it parameterised

    @Override
    public boolean isConditionFulFilled(final Product product) {
        return product.getQuantity() > QUANTITY;
    }
}
