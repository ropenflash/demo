package com.example.demo.UserController;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExecption extends RuntimeException {

    public UserNotFoundExecption(String message) {
        super(message);
    }
    
}
