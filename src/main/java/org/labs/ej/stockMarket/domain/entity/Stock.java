package org.labs.ej.stockMarket.domain.entity;

import java.sql.Timestamp;

public class Stock {
    private Long id;
    private String name;
    private Double currentPrice;
    private Timestamp lastUpdate;

    private Stock(Long id, String name, Double currentPrice, Timestamp lastUpdate) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
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

        public Builder setId(Long id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCurrentPrice(Double currentPrice) {
            this.currentPrice = currentPrice;
            return this;
        }

        public Builder setLastUpdate(Timestamp lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Stock build() {
            return new Stock(id, name, currentPrice, lastUpdate);
        }
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentPrice=" + currentPrice +
                ", lastUpdate=" + lastUpdate +
                '}';
    }
}
