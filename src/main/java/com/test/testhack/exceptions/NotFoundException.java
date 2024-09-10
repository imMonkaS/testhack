package com.test.testhack.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {
    public NotFoundException(Long item_id, String item_name) {
        super(item_name + " with id: " + item_id + " is not found.");
    }

    public NotFoundException(String item_name) {
        super(item_name + " is not found.");
    }
}
