package org.labs.ej.stockMarket.domain.mapper;

import org.labs.ej.stockMarket.dataSource.model.StockData;
import org.labs.ej.stockMarket.domain.entity.Stock;

import java.util.List;
import java.util.stream.Collectors;

public class StockMapperImpl implements StockMapper {
    public List<Stock> convertStockDataListToStockList(List<StockData> stockDataList) {
        return stockDataList.stream().map(stockData -> new Stock.Builder(stockData.getId())
                .setName(stockData.getName())
                .setCurrentPrice(stockData.getCurrentPrice())
                .setLastUpdate(stockData.getLastUpdate())
                .build()
        ).collect(Collectors.toList());
    }

    @Override
    public List<StockData> convertStockListToStockDataList(List<Stock> stockList) {
        return null;
    }

    @Override
    public Stock convertStockDataToStock(StockData stockData) {
        return new Stock.Builder(stockData.getId())
                .setName(stockData.getName())
                .setCurrentPrice(stockData.getCurrentPrice())
                .setLastUpdate(stockData.getLastUpdate())
                .build();
    }

    @Override
    public StockData convertStockToStockData(Stock stock) {
        return new StockData.Builder(stock.getId())
                .setName(stock.getName())
                .setCurrentPrice(stock.getCurrentPrice())
                .setLastUpdate(stock.getLastUpdate())
                .build();
    }
}
