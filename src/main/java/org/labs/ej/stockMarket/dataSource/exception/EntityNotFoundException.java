package org.labs.ej.stockMarket.dataSource.exception;

public class EntityNotFoundException  extends RuntimeException {
    public EntityNotFoundException(String message) {
        super(message);
    }
}
