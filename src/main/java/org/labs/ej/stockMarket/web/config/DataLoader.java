package org.labs.ej.stockMarket.web.config;

import org.labs.ej.stockMarket.domain.entity.Stock;
import org.labs.ej.stockMarket.domain.service.StockService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {
    private final StockService stockService;

    public DataLoader(StockService stockService) {
        this.stockService = stockService;
    }

    @Override
    public void run(ApplicationArguments args) {
        // it could load from the disk or network
        Stock stock = new Stock.Builder()
                .setName("Adidas")
                .setCurrentPrice("22")
                .build();
        stockService.save(stock);

        Stock stock2 = new Stock.Builder()
                .setName("Nike")
                .setCurrentPrice("222")
                .build();

        stockService.save(stock2);
    }
}
