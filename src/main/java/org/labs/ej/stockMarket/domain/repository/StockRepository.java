package org.labs.ej.stockMarket.domain.repository;

import org.labs.ej.stockMarket.domain.entity.Stock;

import java.util.List;

public interface StockRepository {
    
    List<Stock> getAllCategories();

    Stock getStock(Long id);

    Stock create(Stock stock);

    void update(Stock stock);
}
