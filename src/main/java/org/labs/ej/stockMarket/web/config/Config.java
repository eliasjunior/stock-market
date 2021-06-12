package org.labs.ej.stockMarket.web.config;

import org.labs.ej.stockMarket.dataSource.model.StockData;
import org.labs.ej.stockMarket.dataSource.repository.MemoryDataStore;
import org.labs.ej.stockMarket.dataSource.validator.StockValidator;
import org.labs.ej.stockMarket.domain.mapper.StockMapper;
import org.labs.ej.stockMarket.domain.mapper.StockMapperImpl;
import org.labs.ej.stockMarket.domain.util.JavaIDGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Config {

    @Bean
    public MemoryDataStore createStoreDataStore() {
        List<StockData> stockDataList = getListFromSomeWhere();
        return new MemoryDataStore(stockDataList, new JavaIDGenerator(), new StockValidator());
    }

    @Bean
    public StockMapper createStockMapper() {
        return new StockMapperImpl();
    }

    private List<StockData> getListFromSomeWhere() {
        //TODO maybe replace reading from a file
        StockData stockData = new StockData.Builder(Long.valueOf("11"))
                .setName("Test")
                .setCurrentPrice(2.5)
                .setLastUpdate(Timestamp.valueOf(LocalDateTime.now()))
                .build();

        List<StockData> list = new ArrayList<>();
        list.add(stockData);
        return list;
    }

}
