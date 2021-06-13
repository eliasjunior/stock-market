package org.labs.ej.stockMarket.dataSource.repository;

import org.labs.ej.stockMarket.dataSource.exception.EntityNotFoundException;
import org.labs.ej.stockMarket.dataSource.model.StockData;
import org.labs.ej.stockMarket.dataSource.validator.Validator;
import org.labs.ej.stockMarket.domain.util.IdGenerator;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

public class MemoryDataStore implements StockDataStore {
    //TODO REVIEW here need to inject dataGuy
    private List<StockData> stockDataList;
    private final IdGenerator idGenerator;
    private final Validator<StockData> validator;

    public MemoryDataStore(List<StockData> stockDataList, IdGenerator idGenerator, Validator<StockData> validator) {
        this.stockDataList = stockDataList;
        this.idGenerator = idGenerator;
        this.validator = validator;
    }

    @Override
    public StockData save(StockData stockData) {
        stockData.setId(Long.valueOf(idGenerator.generateId()));
        stockData.setLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
        this.validator.validatePost(stockData);
        stockDataList.add(stockData);
        return stockData;
    }

    @Override
    public void update(StockData stockData) {
        StockData updateStock = getStock(stockData.getId());
        this.validator.validatePut(stockData);
        updateStock.setCurrentPrice(stockData.getCurrentPrice());
        updateStock.setLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
    }

    @Override
    public List<StockData> getStocks() {
        return stockDataList;
    }

    @Override
    public StockData getStock(Long id) {
        try {
            return stockDataList.stream()
                    .filter(stockData -> stockData.getId().equals(id))
                    .findFirst()
                    .orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException("Attempt to get stock has failed, stock.id=" + id + " was not found");
        }
    }
}
