package com.project.SIAP.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EmailAlreadyExistsException extends ResponseStatusException {

    public EmailAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
