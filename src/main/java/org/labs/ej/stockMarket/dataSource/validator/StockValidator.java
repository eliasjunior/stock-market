package org.labs.ej.stockMarket.dataSource.validator;

import org.labs.ej.stockMarket.dataSource.exception.CustomValidationException;
import org.labs.ej.stockMarket.dataSource.model.StockData;

import java.util.Objects;

public class StockValidator implements Validator<StockData> {
    @Override
    public void validatePost(StockData stockData) {
        if (Objects.isNull(stockData.getName()) || stockData.getName().isEmpty()) {
            throw new CustomValidationException("Attempt to save stock has failed! name is required");
        }
        checkStock(stockData.getCurrentPrice());
    }

    @Override
    public void validatePut(StockData stockData) {
        checkStock(stockData.getCurrentPrice());
    }

    private void checkStock(Double currentPrice) {
        if (Objects.isNull(currentPrice)) {
            throw new CustomValidationException("Attempt to save stock has failed! stock price is required");
        }
    }
}
