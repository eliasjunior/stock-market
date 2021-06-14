package org.labs.ej.stockMarket.web.controller;

import org.labs.ej.stockMarket.domain.exception.CustomValidationException;
import org.labs.ej.stockMarket.domain.exception.EntityNotFoundException;
import org.labs.ej.stockMarket.data.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerErrorHandler {
    @ExceptionHandler(CustomValidationException.class)
    public ResponseEntity<Error> handleClientInput(CustomValidationException e) {
        return new ResponseEntity<>(new Error(e.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Error> handleRuntimeError(EntityNotFoundException e) {
        return new ResponseEntity<>(new Error(e.getLocalizedMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Error> handleRuntimeError(RuntimeException e) {
        if (e.getLocalizedMessage().contains("Cannot deserialize value of type")) {
            return new ResponseEntity<>(new Error("Form contain  incompatible types"), HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new Error(e.getLocalizedMessage()), HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleRuntimeError(Exception e) {
        return new ResponseEntity<>(new Error(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
