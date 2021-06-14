package org.labs.ej.stockMarket.domain.service;

import org.labs.ej.stockMarket.domain.entity.Stock;

import java.util.List;

public interface StockService {
    Stock save(Stock stock);
    void update(Stock stockData);
    List<Stock> getStocks();
    Stock getStock(String id);
}
