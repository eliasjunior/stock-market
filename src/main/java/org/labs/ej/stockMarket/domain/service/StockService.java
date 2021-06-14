package org.labs.ej.stockMarket.domain.service;

import org.labs.ej.stockMarket.domain.entity.Stock;

import java.util.List;

// Gateway between the domain biz logic
public interface StockService {
    Stock save(Stock stock);
    void update(Stock stockData);
    List<Stock> getStocks();
    Stock getStock(String id);
}
