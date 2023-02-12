package com.github.product.buy;

import lombok.Builder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Builder
public class ProductScore {
    private final List<Rule> rules;

    public Map<Product, Double> calculateProductScores(List<Product> products) {
        return products.stream()
                .collect(Collectors.toMap(product -> product, this::applyRules));
    }

    private double applyRules(Product product) {
        return rules.stream()
                .mapToDouble(rule -> {
                    double matchedConditionsCount = getMatchedConditionsCount(product, rule);
                    double score = calculateRuleScore(rule, matchedConditionsCount);
                    return flipScore(rule, score);
                })
                .sum();
    }

    private double calculateRuleScore(Rule rule, double matchedConditionsCount) {
        return (matchedConditionsCount / rule.getConditions().size()) * 100 * rule.getScore();
    }

    private double flipScore(Rule rule, double score) {
        return rule.isRulePositive() ? score : (0 - score);
    }

    private double getMatchedConditionsCount(Product product, Rule rule) {
        return rule.getConditions().stream()
                .filter(condition -> condition.isConditionFulFilled(product))
                .count();
    }
}
