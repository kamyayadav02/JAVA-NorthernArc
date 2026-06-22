package org.northernarc.springdatajpademo2.controllerAdvice;

import org.northernarc.springdatajpademo2.exceptions.CustomerNotFound;
import org.northernarc.springdatajpademo2.exceptions.FlightNotFound;
import org.northernarc.springdatajpademo2.exceptions.TicketNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {



    @ExceptionHandler(CustomerNotFound.class)
    public ResponseEntity<Map<String, String>> handleCustomerNotFound(CustomerNotFound e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }


    @ExceptionHandler(FlightNotFound.class)
    public ResponseEntity<Map<String, String>> handleFlightNotFound(FlightNotFound e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

    @ExceptionHandler(TicketNotFound.class)
    public ResponseEntity<Map<String, String>> handleTicketNotFound(TicketNotFound e) {
        return new ResponseEntity<>(
                Map.of("message", e.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }



}
