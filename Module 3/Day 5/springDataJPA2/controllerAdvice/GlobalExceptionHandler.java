package org.northernarc.springdatajpademo1.controllerAdvice;

import org.northernarc.springdatajpademo1.exceptions.CustomerNotFound;
import org.northernarc.springdatajpademo1.exceptions.ProductNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFound.class)
    public ResponseEntity<Map<String, String>> handleProductNotFound(ProductNotFound e) {
        Map<String, String> map = Map.of("message", e.getMessage());
        return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<Map<String, String>> handleCustomerNotFound(CustomerNotFound e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }


}