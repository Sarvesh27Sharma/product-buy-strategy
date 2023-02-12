package com.github.product.buy;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Builder
public class ProductBuyStrategyService {

    private final ProductScore productScore;
    private final int thresholdScore;
    private final int highScore;

    public Map<Product, Double> getAllProductScores(final List<Product> products) {
        return productScore.calculateProductScores(products);
    }

    //TODO: remove redundant call productScore.getProductScores(products)
    public List<Product> filteredProducts(final List<Product> products) {
        Map<Product, Double> productScores = productScore.calculateProductScores(products);

        return productScores.entrySet().stream()
                .filter(productScore -> productScore.getValue() > thresholdScore)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    //TODO: remove redundant call productScore.getProductScores(products)
    public Map<String, Double> calculatePriceForHighScoreProducts(final List<Product> products) {
        Map<Product, Double> productScores = productScore.calculateProductScores(products);

        List<Double> highScores = productScores.values().stream()
                .filter(aDouble -> aDouble > highScore)
                .collect(Collectors.toList());

        double totalPrice = highScores.stream().mapToDouble(score -> score).sum();
        double avgPrice = totalPrice / highScores.size();
        return Map.of("TOTAL_PRICE", totalPrice,
                "AVG_PRICE", avgPrice);
    }
}
