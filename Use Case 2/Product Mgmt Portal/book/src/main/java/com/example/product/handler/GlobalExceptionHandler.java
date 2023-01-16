package com.example.product.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.product.exception.GlobalException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GlobalException.class)
    public ResponseEntity handleGlobalException(GlobalException globalException)
    {
        return new ResponseEntity<>(globalException.getError() , HttpStatus.ACCEPTED);
    }
}
