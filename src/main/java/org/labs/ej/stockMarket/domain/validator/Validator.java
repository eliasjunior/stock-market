package org.labs.ej.stockMarket.domain.validator;

public interface Validator<T> {
    void validate(T t);
}
