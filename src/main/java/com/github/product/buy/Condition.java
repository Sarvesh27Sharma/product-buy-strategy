package com.github.product.buy;

//TODO: make it more generic with attribute, operator & value
public interface Condition {
    boolean isConditionFulFilled(final Product product);
}
