package org.labs.ej.stockMarket.domain.entity;

public class Stock {
    private String id;
    private String name;
    private String currentPrice;
    private String lastUpdate;

    private Stock(String id, String name, String currentPrice, String lastUpdate) {
        this.id = id;
        this.name = name;
        this.currentPrice = currentPrice;
        this.lastUpdate = lastUpdate;
    }

    public static class Builder {
        private String id;
        private String name;
        private String currentPrice;
        private String lastUpdate;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setCurrentPrice(String currentPrice) {
            this.currentPrice = currentPrice;
            return this;
        }

        public Builder setLastUpdate(String lastUpdate) {
            this.lastUpdate = lastUpdate;
            return this;
        }

        public Stock build() {
            return new Stock(id, name, currentPrice, lastUpdate);
        }
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCurrentPrice() {
        return currentPrice;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
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
