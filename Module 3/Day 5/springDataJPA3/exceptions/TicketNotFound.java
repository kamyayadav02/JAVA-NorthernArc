package org.northernarc.springdatajpademo2.exceptions;

public class TicketNotFound extends RuntimeException {
    public TicketNotFound(String message) {
        super(message);
    }
}
