package org.labs.ej.stockMarket.dataSource.validator;

public interface Validator<T> {
    void validate(T t);
}
