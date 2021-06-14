package org.labs.ej.stockMarket.domain.mapper;

import org.labs.ej.stockMarket.domain.exception.CustomValidationException;
import org.labs.ej.stockMarket.data.model.StockData;
import org.labs.ej.stockMarket.domain.entity.Stock;
import org.slf4j.Logger;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

public class StockMapperImpl implements StockMapper {
    private final Logger logger;

    public StockMapperImpl(Logger logger) {
        this.logger = logger;
    }

    public List<Stock> convertStockDataListToStockList(List<StockData> stockDataList) {
        if(stockDataList == null) {
            throw new CustomValidationException("Attempt convert stockData has failed! stockData cannot be null");
        }
        try {
            return stockDataList.stream().map(stockData -> new Stock.Builder()
                    .setId(String.valueOf(stockData.getId()))
                    .setName(stockData.getName())
                    .setCurrentPrice(String.valueOf(stockData.getCurrentPrice()))
                    .setLastUpdate(String.valueOf(stockData.getLastUpdate()))
                    .build()
            ).collect(Collectors.toList());
        } catch (RuntimeException e) {
            logger.debug(e.getLocalizedMessage());
            throw new CustomValidationException("Attempt read stock has failed!, " + e.getMessage());
        }
    }

    @Override
    public Stock convertStockDataToStock(StockData stockData) {
        if(stockData == null) {
            throw new CustomValidationException("Attempt convert stockData has failed! stockData cannot be null");
        }
        try {
            return new Stock.Builder()
                    .setId(String.valueOf(stockData.getId()))
                    .setName(stockData.getName())
                    .setCurrentPrice(String.valueOf(stockData.getCurrentPrice()))
                    .setLastUpdate(String.valueOf(stockData.getLastUpdate()))
                    .build();
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
            throw new CustomValidationException("Attempt read stock has failed!, " + e.getMessage());
        }
    }

    @Override
    public StockData convertStockToStockData(Stock stock) {
        if(stock == null) {
            throw new CustomValidationException("Attempt convert stock has failed! stock cannot be null");
        }
        try {
            return new StockData.Builder(getLongValue(stock.getId()))
                    .setName(stock.getName())
                    .setCurrentPrice(getDoubleValue(stock.getCurrentPrice()))
                    .setLastUpdate(getTimeValue(stock.getLastUpdate()))
                    .build();
        } catch (Exception e) {
            logger.debug(e.getLocalizedMessage());
            throw new CustomValidationException("Attempt read stock has failed!, " + e.getMessage());
        }
    }

    private Double getDoubleValue(String value) {
        return value != null && !value.isEmpty() ? Double.valueOf(value) : null;
    }

    private Long getLongValue(String value) {
        return value != null && !value.isEmpty() ? Long.valueOf(value) : null;
    }

    private Timestamp getTimeValue(String value) {
        return value != null && !value.isEmpty() ? Timestamp.valueOf(value) : null;
    }
}
