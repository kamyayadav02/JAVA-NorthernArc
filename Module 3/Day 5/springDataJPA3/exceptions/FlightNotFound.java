package org.northernarc.springdatajpademo2.exceptions;

public class FlightNotFound extends RuntimeException{

    public FlightNotFound(String message) {
        super(message);
    }
}
