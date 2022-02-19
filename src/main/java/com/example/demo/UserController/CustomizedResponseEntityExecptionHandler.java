package com.example.demo.UserController;

import java.util.Date;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.catalina.startup.WebAnnotationSet;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExecptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request){
       ExceptionResponse response= new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false) );

        return new ResponseEntity(response, HttpStatus.BAD_REQUEST);
    }

    
    @ExceptionHandler(UserNotFoundExecption.class)
    public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundExecption ex, WebRequest request){
       ExceptionResponse response= new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false) );

        return new ResponseEntity(response, HttpStatus.NOT_FOUND);
    }
}
