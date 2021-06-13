package org.labs.ej.stockMarket.web.config;

import org.labs.ej.stockMarket.dataSource.model.StockData;
import org.labs.ej.stockMarket.dataSource.repository.MemoryDataStore;
import org.labs.ej.stockMarket.dataSource.repository.StockDataStore;
import org.labs.ej.stockMarket.dataSource.validator.StockValidator;
import org.labs.ej.stockMarket.domain.mapper.StockMapper;
import org.labs.ej.stockMarket.domain.mapper.StockMapperImpl;
import org.labs.ej.stockMarket.domain.util.JavaIDGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                final String[] HOSTS_ALLOWED = {"http://localhost:3000"};
                registry.addMapping("/**")
                        .allowedMethods("*")
                        .allowedOrigins(HOSTS_ALLOWED);
            }
        };
    }

    @Bean
    public StockDataStore createStoreDataStore() {
        StockDataStore stockDataStore =
                new MemoryDataStore(new ArrayList<>(), new JavaIDGenerator(), new StockValidator());
        List<StockData> stockDataList = getListFromSomeWhere();
        stockDataList.forEach(stockDataStore::save);
        return stockDataStore;
    }

    @Bean
    public StockMapper createStockMapper() {
        return new StockMapperImpl();
    }

    private List<StockData> getListFromSomeWhere() {
        StockData stockData = new StockData.Builder()
                .setName("Adidas")
                .setCurrentPrice(22.0)
                .setLastUpdate(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        StockData stockData2 = new StockData.Builder()
                .setName("Nike")
                .setCurrentPrice(21.4)
                .setLastUpdate(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        List<StockData> list = new ArrayList<>();
        list.add(stockData);
        list.add(stockData2);
        return list;
    }

}
