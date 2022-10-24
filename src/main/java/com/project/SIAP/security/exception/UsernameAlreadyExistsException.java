package com.project.SIAP.security.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class UsernameAlreadyExistsException extends ResponseStatusException {

    public UsernameAlreadyExistsException(String message) {
        super(HttpStatus.CONFLICT, message);
    }
}
