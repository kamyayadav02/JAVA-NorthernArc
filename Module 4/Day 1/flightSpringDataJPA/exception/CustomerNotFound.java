package org.northernarc.springdatajpademo2.exceptions;

public class CustomerNotFound extends RuntimeException{

    public CustomerNotFound(String message) {
        super(message);
    }
}
