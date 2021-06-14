package org.labs.ej.stockMarket.web.controller;

import org.labs.ej.stockMarket.domain.entity.Stock;
import org.labs.ej.stockMarket.domain.service.StockService;
import org.labs.ej.stockMarket.domain.util.Constants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Constants.BASE_URL + "/stocks")
public class StockController {
    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @GetMapping
    public List<Stock> getStocks() {
        return stockService.getStocks();
    }

    @GetMapping("/{id}")
    public Stock getStock(@PathVariable String id) {
        return stockService.getStock(id);
    }

    @PostMapping
    public Stock create(@RequestBody Stock stock) {
        return stockService.save(stock);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody Stock stock) {
        stockService.update(stock);
        return ResponseEntity.noContent().build();
    }
}
