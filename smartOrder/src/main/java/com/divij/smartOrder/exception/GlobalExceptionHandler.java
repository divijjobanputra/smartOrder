package com.divij.smartOrder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex){
        ErrorResponse err = new ErrorResponse(404, ex.getMessage());
        return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleResourceNotFound(MethodArgumentNotValidException ex){
        ErrorResponse err = new ErrorResponse(400, ex.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
    }
}
