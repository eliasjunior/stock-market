package org.labs.ej.stockMarket.web.controller;

import org.labs.ej.stockMarket.dataSource.exception.CustomValidationException;
import org.labs.ej.stockMarket.dataSource.model.StockData;
import org.labs.ej.stockMarket.dataSource.repository.StockDataStore;
import org.labs.ej.stockMarket.domain.entity.Stock;
import org.labs.ej.stockMarket.domain.mapper.StockMapper;
import org.labs.ej.stockMarket.domain.util.Constants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL + "/stocks")
public class StockController {
    // TODO review here to make comments why is crossing boundaries
    private final StockDataStore stockDataStore;
    private final StockMapper stockMapper;

    public StockController(StockDataStore stockDataStore, StockMapper stockMapper) {
        this.stockDataStore = stockDataStore;
        this.stockMapper = stockMapper;
    }

    @GetMapping
    public List<Stock> getStocks() {
        return stockMapper.convertStockDataListToStockList(stockDataStore.getStocks());
    }

    @GetMapping("/{id}")
    public Stock getStock(@PathVariable String id) {
        return stockMapper.convertStockDataToStock(stockDataStore.getStock(Long.valueOf(id)));
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        StockData stockData = stockMapper.convertStockToStockData(stock);
        return stockMapper.convertStockDataToStock(stockDataStore.save(stockData));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Stock stock) {
        StockData stockData = stockMapper.convertStockToStockData(stock);
        stockDataStore.update(stockData);
        return ResponseEntity.noContent().build();
    }
}
