package com.github.product.buy;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Setter
@Getter
@Configuration
public class AppConfig {

    @Value("${thresholdScore}")
    private Integer thresholdScore;
    @Value("${highScore}")
    private Integer highScore;

    @Bean
    public ProductScore productScore(List<Rule> rules) {
        return ProductScore.builder()
                .rules(rules)
                .build();
    }

    @Bean
    public ProductBuyStrategyService productBuyStrategyService(ProductScore productScore) {
        return ProductBuyStrategyService.builder()
                .productScore(productScore)
                .highScore(highScore)
                .thresholdScore(thresholdScore)
                .build();
    }
}
