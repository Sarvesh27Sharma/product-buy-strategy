package com.github.product.buy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@SpringBootApplication(scanBasePackages = "com.github.product.buy")
public class App implements CommandLineRunner {
    private final ProductBuyStrategyService productBuyStrategyService;

    public App(ProductBuyStrategyService productBuyStrategyService) {
        this.productBuyStrategyService = productBuyStrategyService;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(String... args) {
        Map<String, Double> prices = productBuyStrategyService.calculatePriceForHighScoreProducts(createProducts());
        log.info("total price for high score products is [{}] ", prices.get("TOTAL_PRICE"));
        log.info("avg price for high score products is [{}] ", prices.get("AVG_PRICE"));
    }

    private static List<Product> createProducts() {
        return List.of(createProduct("BLUE", BigDecimal.valueOf(16.00d), 1000L, "TIE"),
                createProduct("BLACK", BigDecimal.valueOf(10.00d), 1000L, "SHOE"),
                createProduct("BLUE", BigDecimal.valueOf(180.00d), 1000L, "SOCKS"),
                createProduct("BLUE", BigDecimal.valueOf(18.00d), 100L, "HAT"),
                createProduct("RED", BigDecimal.valueOf(180.00d), 1000L, "PANT"),
                createProduct("BLUE", BigDecimal.valueOf(18.00d), 100L, "SHIRT"),
                createProduct("YELLOW", BigDecimal.valueOf(15.00d), 100L, "SHIRT")
        );
    }

    private static Product createProduct(String color, BigDecimal cost, Long quantity, String name) {
        return Product.builder()
                .color(color)
                .cost(cost)
                .name(name)
                .quantity(quantity)
                .build();
    }
}
