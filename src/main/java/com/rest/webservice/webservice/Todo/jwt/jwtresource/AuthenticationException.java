package com.rest.webservice.webservice.Todo.jwt.jwtresource;

public class AuthenticationException extends RuntimeException {
    public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
