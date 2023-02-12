package com.github.product.buy;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class Product {
    private final String name;
    private final String type;
    private final String color;
    private final BigDecimal cost;
    private final Double weight;
    private final Long quantity;
}
