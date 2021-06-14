package org.labs.ej.stockMarket.data.repository;

import org.labs.ej.stockMarket.data.model.StockData;

import java.util.List;

// Here is the contract of the store, we could implement several types of persistence
public interface StockDataStore {
    StockData save(StockData stockData);
    void update(StockData stockData);
    List<StockData> getStocks();
    StockData getStock(Long id);
}
