package org.northernarc.springdatajpademo.exceptions;

public class ProjectNotFound extends RuntimeException {
    public ProjectNotFound(String message) {
        super(message);
    }
}
