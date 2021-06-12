package org.labs.ej.stockMarket.dataSource.repository;

import org.labs.ej.stockMarket.dataSource.model.StockData;

import java.util.List;

public interface StockDataStore {
    StockData save(StockData stockData);
    void update(StockData stockData);
    List<StockData> getStocks();
    StockData getStock(Long id);
}
