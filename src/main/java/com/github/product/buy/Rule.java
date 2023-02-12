package com.github.product.buy;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class Rule {
    private final List<Condition> conditions;
    private final boolean isRulePositive;
    private final int score;
}
