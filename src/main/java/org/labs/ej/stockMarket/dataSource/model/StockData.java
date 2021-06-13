package org.labs.ej.stockMarket.dataSource.model;

import java.sql.Timestamp;

public class StockData {
    private Long id;
    private String name;
    private Double currentPrice;
    private Timestamp lastUpdate;

    private StockData(Long id, String name, Double currentPrice, Timestamp lastUpdate) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public static class Builder {
        private Long id;
        private String name;
        private Double currentPrice;
        private Timestamp lastUpdate;

        public Builder(Long id) {
            this.id = id;
        }
        public Builder() {
        }

        public StockData.Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public StockData.Builder setName(String name) {
            this.name = name;
            return this;
        }

        public StockData.Builder setCurrentPrice(Double currentPrice) {
            this.currentPrice = currentPrice;
            return this;
        }

        public StockData.Builder setLastUpdate(Timestamp lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public StockData build() {
            return new StockData(id, name, currentPrice, lastUpdate);
        }
    }

    @Override
    public String toString() {
        return "StockData{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
