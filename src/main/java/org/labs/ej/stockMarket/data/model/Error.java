package org.labs.ej.stockMarket.data.model;

public class Error {
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public Error(String message) {
        this.message = message;
    }
}
