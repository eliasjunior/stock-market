package org.labs.ej.stockMarket.dataSource.validator;

import org.labs.ej.stockMarket.dataSource.exception.CustomValidationException;
import org.labs.ej.stockMarket.domain.entity.Stock;

import java.util.Objects;

public class StockValidator implements Validator<Stock> {
    @Override
    public void validate(Stock stock) {
        if (Objects.isNull(stock.getName()) || stock.getName().isEmpty()) {
            throw new CustomValidationException("Attempt to save stock has failed! name is required");
        }
        if (Objects.isNull(stock.getCurrentPrice())) {
            throw new CustomValidationException("Attempt to save stock has failed! stock price is required");
        }
    }

}
