package org.labs.ej.stockMarket.domain.interactor;

import org.labs.ej.stockMarket.domain.entity.Stock;
import org.labs.ej.stockMarket.domain.repository.StockRepository;

import java.util.List;

public class FindStock {
    private StockRepository stockRepository;

    public FindStock(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    public List<Stock> getAllCategories() {
        return stockRepository.getAllCategories();
    }

    public Stock getStock(Long id) {
        return stockRepository.getStock(id);
    }
}
