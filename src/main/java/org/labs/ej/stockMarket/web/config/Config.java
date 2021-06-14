package org.labs.ej.stockMarket.web.config;

import org.labs.ej.stockMarket.dataSource.repository.MemoryDataStore;
import org.labs.ej.stockMarket.dataSource.repository.StockDataStore;
import org.labs.ej.stockMarket.dataSource.validator.StockValidator;
import org.labs.ej.stockMarket.domain.mapper.StockMapper;
import org.labs.ej.stockMarket.domain.mapper.StockMapperImpl;
import org.labs.ej.stockMarket.domain.service.StockService;
import org.labs.ej.stockMarket.domain.service.StockServiceImpl;
import org.labs.ej.stockMarket.domain.util.JavaIDGenerator;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;

@Configuration
public class Config {
    @Value("${allowedHost}")
    String allowedHosts;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                final String[] HOSTS_ALLOWED = {allowedHosts};
                registry.addMapping("/**")
                        .allowedMethods("*")
                        .allowedOrigins(HOSTS_ALLOWED);
            }
        };
    }

    @Bean
    public StockService createStockService() {
        return new StockServiceImpl(createStoreDataStore(), createStockMapper(),
                LoggerFactory.getLogger(StockServiceImpl.class), new StockValidator());
    }

    private StockMapper createStockMapper() {
        return new StockMapperImpl(LoggerFactory.getLogger(StockMapperImpl.class));
    }

    private StockDataStore createStoreDataStore() {
        return new MemoryDataStore(new ArrayList<>(), new JavaIDGenerator(),
                LoggerFactory.getLogger(StockDataStore.class));
    }
}
