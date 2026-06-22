package org.northernarc.springdatajpademo1.exceptions;


public class ProductNotFound extends RuntimeException {
    public ProductNotFound(String message) {
        super(message);
    }
}
