package com.example.yxiriatechnicaltest.domain.exception;

public class UserReadNotAllowedException extends Exception {
    public UserReadNotAllowedException(String message) {
        super(message);
    }
}
