package org.labs.ej.stockMarket.web.controller;

import org.labs.ej.stockMarket.dataSource.exception.CustomValidationException;
import org.labs.ej.stockMarket.dataSource.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerErrorHandler {
    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<String> handleClientInput(CustomValidationException e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleRuntimeError(EntityNotFoundException e) {
        return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
    }
}
