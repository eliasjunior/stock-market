package org.labs.ej.stockMarket.domain.service;

import org.labs.ej.stockMarket.domain.exception.CustomValidationException;
import org.labs.ej.stockMarket.data.model.StockData;
import org.labs.ej.stockMarket.data.repository.StockDataStore;
import org.labs.ej.stockMarket.domain.validator.Validator;
import org.labs.ej.stockMarket.domain.entity.Stock;
import org.labs.ej.stockMarket.domain.mapper.StockMapper;
import org.slf4j.Logger;

import java.util.List;

public class StockServiceImpl implements StockService {
    private final StockDataStore stockDataStore;
    private final StockMapper stockMapper;
    private final Logger logger;
    private final Validator<Stock> validator;

    public StockServiceImpl(StockDataStore stockDataStore, StockMapper stockMapper, Logger logger,
                            Validator<Stock> validator) {
        this.stockDataStore = stockDataStore;
        this.stockMapper = stockMapper;
        this.logger = logger;
        this.validator = validator;
    }

    @Override
    public Stock save(Stock stock) {
        this.validator.validate(stock);
        try {
            StockData stockData = stockMapper.convertStockToStockData(stock);
            return stockMapper.convertStockDataToStock(stockDataStore.save(stockData));
        } catch (CustomValidationException e) {
            logger.debug(e.getLocalizedMessage());
            throw new CustomValidationException(e.getLocalizedMessage());
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
            throw new RuntimeException("Attempt to save stock has failed, " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(Stock stock) {
        this.validator.validate(stock);
        try {
            StockData stockData = stockMapper.convertStockToStockData(stock);
            stockDataStore.update(stockData);
        } catch (CustomValidationException e) {
            logger.debug(e.getLocalizedMessage());
            throw new CustomValidationException(e.getLocalizedMessage());
        } catch (RuntimeException e) {
            logger.debug(e.getLocalizedMessage());
            throw new RuntimeException("Attempt to update stock has failed, " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<Stock> getStocks() {
        try {
            List<StockData> list = stockDataStore.getStocks();
            return stockMapper.convertStockDataListToStockList(list);
        } catch (RuntimeException e) {
            logger.debug(e.getLocalizedMessage());
            throw new RuntimeException("Attempt to get stocks has failed, " + e.getLocalizedMessage());
        }
    }

    @Override
    public Stock getStock(String id) {
        try {
            return stockMapper.convertStockDataToStock(stockDataStore.getStock(Long.valueOf(id)));
        } catch (NumberFormatException e) {
            logger.debug(e.getLocalizedMessage());
            throw new RuntimeException("Attempt to get stock has failed, " + e.getLocalizedMessage());
        }
    }
}
