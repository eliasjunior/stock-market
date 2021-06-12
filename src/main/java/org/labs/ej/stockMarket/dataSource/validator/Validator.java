package org.labs.ej.stockMarket.dataSource.validator;

public interface Validator<T> {
    void validatePost(T t);
    void validatePut(T t);
}
