//package org.labs.ej.stockMarket.dataSource.repository;
//
//import org.labs.ej.stockMarket.dataSource.model.StockData;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class FileDataSource implements StockDataStore {
//    private final String CSV_SEPARATOR = ",";
//    private final Path path;
//
//    public FileDataSource(Path path) {
//        this.path = path;
//    }
//
//
//    @Override
//    public StockData save(StockData stockData) {
//        throw new RuntimeException("Operation not supported to this datasource");
//    }
//
//    @Override
//    public List<StockData> getStocks() {
//        try(Stream<String> lines = Files.lines(path) ) {
//            return lines
//                    .map(line -> line.split(CSV_SEPARATOR))
//                    .map( -> {})
//                    .collect(Collectors.toList());
//        } catch (IOException e) {
//            //TODO logger ?
//            throw e;
//        } finally {
//            lines.close();
//        }
//        return null;
//    }
//}
