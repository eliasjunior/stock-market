package org.labs.ej.stockMarket.domain.service;

import org.junit.jupiter.api.Test;
import org.labs.ej.stockMarket.domain.exception.CustomValidationException;
import org.labs.ej.stockMarket.data.repository.StockDataStore;
import org.labs.ej.stockMarket.domain.entity.Stock;
import org.labs.ej.stockMarket.domain.mapper.StockMapper;
import org.labs.ej.stockMarket.domain.mapper.StockMapperImpl;
import org.labs.ej.stockMarket.domain.validator.Validator;
import org.mockito.Mockito;
import org.slf4j.Logger;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class StockServiceImplTest {

    @Test
    void testShouldThrowCustomException() {
        StockDataStore stockDataStore = Mockito.mock(StockDataStore.class);

        Logger logger = Mockito.mock(Logger.class);
        StockMapper stockMapper = new StockMapperImpl(logger);
        Validator<Stock> validator =  Mockito.mock(Validator.class);
        StockService stockService = new StockServiceImpl(stockDataStore, stockMapper, logger, validator);

        Stock stock = new Stock.Builder().setName("Test").setCurrentPrice("2").build();
        assertThrows(CustomValidationException.class, () -> stockService.save(stock));
    }

    @Test
    void testShouldThrowCustomExceptionWhenInputIsMissing() {
        StockDataStore stockDataStore = Mockito.mock(StockDataStore.class);

        Logger logger = Mockito.mock(Logger.class);
        StockMapper stockMapper = new StockMapperImpl(logger);
        Validator<Stock> validator =  Mockito.mock(Validator.class);
        StockService stockService = new StockServiceImpl(stockDataStore, stockMapper, logger, validator);

        assertThrows(CustomValidationException.class, () -> stockService.save(new Stock.Builder().setName("Test").build()));
        assertThrows(CustomValidationException.class, () -> stockService.save(new Stock.Builder().setCurrentPrice("22").build()));
    }
}