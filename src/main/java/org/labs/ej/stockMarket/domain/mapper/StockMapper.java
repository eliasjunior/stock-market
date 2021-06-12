package org.labs.ej.stockMarket.domain.mapper;

import org.labs.ej.stockMarket.dataSource.model.StockData;
import org.labs.ej.stockMarket.domain.entity.Stock;

import java.util.List;

public interface StockMapper {
    List<Stock> convertStockDataListToStockList(List<StockData> stockDataList);
    List<StockData> convertStockListToStockDataList(List<Stock> stockList);
    Stock convertStockDataToStock(StockData stockData);
    StockData convertStockToStockData(Stock stock);
}
