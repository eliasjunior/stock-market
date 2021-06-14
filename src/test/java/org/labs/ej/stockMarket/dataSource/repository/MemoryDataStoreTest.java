package org.labs.ej.stockMarket.dataSource.repository;

import org.junit.jupiter.api.Test;
import org.labs.ej.stockMarket.dataSource.exception.EntityNotFoundException;
import org.labs.ej.stockMarket.dataSource.model.StockData;
import org.labs.ej.stockMarket.domain.mapper.StockMapper;
import org.labs.ej.stockMarket.domain.mapper.StockMapperImpl;
import org.labs.ej.stockMarket.domain.service.StockService;
import org.labs.ej.stockMarket.domain.service.StockServiceImpl;
import org.labs.ej.stockMarket.domain.util.IdGenerator;
import org.labs.ej.stockMarket.domain.util.JavaIDGenerator;
import org.labs.ej.stockMarket.domain.validator.Validator;
import org.mockito.Mockito;
import org.slf4j.Logger;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
class MemoryDataStoreTest {

    @Test
    void testShouldSave() {
        Logger logger = Mockito.mock(Logger.class);
        IdGenerator idGenerator = Mockito.mock(IdGenerator.class);
        StockDataStore stockDataStore = new MemoryDataStore(new ArrayList<>(), idGenerator, logger);

        when(idGenerator.generateId()).thenReturn(1L);

        assertEquals(1, stockDataStore.save(new StockData.Builder().setCurrentPrice(2.0).build()).getId());
    }

    @Test
    void testShouldThrowClearMessageWhenIdIsNotFound() {
        Logger logger = Mockito.mock(Logger.class);
        IdGenerator idGenerator = Mockito.mock(IdGenerator.class);
        StockDataStore stockDataStore = new MemoryDataStore(new ArrayList<>(), idGenerator, logger);
        EntityNotFoundException exception  = assertThrows(EntityNotFoundException.class, () -> stockDataStore.getStock(1L));

        assertTrue(exception.getMessage().contains("Attempt to get stock has failed"));
    }
}