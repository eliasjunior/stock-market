package org.labs.ej.stockMarket.domain.interactor;

import org.labs.ej.stockMarket.dataSource.repository.StockDataStore;
import org.labs.ej.stockMarket.domain.entity.Stock;
import org.labs.ej.stockMarket.domain.mapper.StockMapper;
import org.labs.ej.stockMarket.domain.util.IdGenerator;
import org.labs.ej.stockMarket.dataSource.validator.Validator;

public class ManageStock {
    private final Validator<Stock> validator;
    private final IdGenerator idGenerator;
    // private final StockRepository stockRepository;
    //TODO  review here
    private final StockDataStore stockDataStore;
    private final StockMapper stockMapper;

    public ManageStock(Validator<Stock> validator, IdGenerator idGenerator, StockDataStore stockDataStore, StockMapper stockMapper) {
        this.validator = validator;
        this.idGenerator = idGenerator;
        this.stockDataStore = stockDataStore;
        this.stockMapper = stockMapper;
    }

    public Stock create(Stock stock) {
       // this.validator.validate(stock);
        stock.setId(Long.valueOf(idGenerator.generateId()));
        this.stockDataStore.save(stockMapper.convertStockToStockData(stock));
        return stock;
    }

    public void update(Stock stock) {
      //  this.validator.validate(stock);
        this.stockDataStore.save(stockMapper.convertStockToStockData(stock));
    }
}
