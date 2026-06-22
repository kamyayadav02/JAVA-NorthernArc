package org.northernarc.springdatajpademo1.exceptions;


public class CustomerNotFound extends RuntimeException {
    public CustomerNotFound(String message) {
        super(message);
    }
}
