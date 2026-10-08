package com.example.mspaymentservice.controller;

import com.example.mspaymentservice.exceptions.PaymentNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestControllerAdvice
public class GlobalHandlerException {
    @ResponseStatus(NOT_FOUND)
    @ExceptionHandler(PaymentNotFoundException.class)
    public ErrorResponse handleException(PaymentNotFoundException ex) {
        return new ErrorResponse("courier.not.found" , ex.getMessage());
    }
}
