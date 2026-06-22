package org.northernarc.springdatajpademo.controllerAdvice;

import org.northernarc.springdatajpademo.exceptions.EmployeeNotFound;
import org.northernarc.springdatajpademo.exceptions.ErrorMessage;
import org.northernarc.springdatajpademo.exceptions.ProjectNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice

public class GlobalExceptionHandler {
    @ExceptionHandler(ProjectNotFound.class)
    public ResponseEntity <Map<String,String>> handler1(ProjectNotFound e){
        Map<String,String> map=Map.of("message", e.getMessage());
        return new ResponseEntity(map,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(EmployeeNotFound.class)
    public ResponseEntity<ErrorMessage> handler2(EmployeeNotFound e){
        ErrorMessage employeeNotFound=new ErrorMessage(e.getMessage());
        return  ResponseEntity.status(404).body(employeeNotFound);
    }

}
