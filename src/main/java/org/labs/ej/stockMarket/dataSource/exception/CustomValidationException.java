package org.labs.ej.stockMarket.dataSource.exception;

public class CustomValidationException extends RuntimeException {
    public CustomValidationException(String message) {
        super(message);
    }
}
