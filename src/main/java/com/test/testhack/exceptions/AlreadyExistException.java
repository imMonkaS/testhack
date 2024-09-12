package com.test.testhack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class AlreadyExistException extends RuntimeException {
    public AlreadyExistException(String username) {
        super("User with username '" + username + "' already exist.");
    }
}
