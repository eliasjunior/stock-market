package org.labs.ej.stockMarket.data.repository.dataSource;

import org.labs.ej.stockMarket.domain.exception.EntityNotFoundException;
import org.labs.ej.stockMarket.data.model.StockData;
import org.labs.ej.stockMarket.data.repository.StockDataStore;
import org.labs.ej.stockMarket.domain.util.IdGenerator;
import org.slf4j.Logger;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

public class MemoryDataStore implements StockDataStore {
    private List<StockData> inMemoryList; // we could inject another type of persistence here
    private final IdGenerator idGenerator;
    private final Logger logger;

    // avoid create dependencies in the class and taking advantage of dependency
    // injection
    public MemoryDataStore(List<StockData> inMemoryList, IdGenerator idGenerator,
                           Logger logger) {
        this.inMemoryList = inMemoryList;
        this.idGenerator = idGenerator;
        this.logger = logger;
    }

    @Override
    public StockData save(StockData stockData) {
        try {
            stockData.setId(idGenerator.generateId());
            stockData.setLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
            inMemoryList.add(stockData);
            return stockData;
        } catch (RuntimeException e) {
            this.logger.debug(e.getLocalizedMessage());
            throw new RuntimeException("Attempt to save stock has failed, " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(StockData stockData) {
        try {
            StockData updateStock = getStock(stockData.getId());
            updateStock.setCurrentPrice(stockData.getCurrentPrice());
            updateStock.setLastUpdate(Timestamp.valueOf(LocalDateTime.now()));
            updateStock.setName(stockData.getName());
        } catch (RuntimeException e) {
            this.logger.debug(e.getLocalizedMessage());
            throw new RuntimeException("Attempt to update stock has failed, " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<StockData> getStocks() {
        return inMemoryList;
    }

    @Override
    public StockData getStock(Long id) {
        try {
            return inMemoryList.stream()
                    .filter(stockData -> stockData.getId().equals(id))
                    .findFirst()
                    .orElseThrow();
        } catch (NoSuchElementException e) {
            this.logger.debug(e.getLocalizedMessage());
            throw new EntityNotFoundException("Attempt to get stock has failed, stock.id=" + id + " was not found");
        } catch (RuntimeException e) {
            this.logger.debug(e.getLocalizedMessage());
            throw new RuntimeException("Attempt to retrieve stock has failed, " + e.getLocalizedMessage());
        }
    }
}
