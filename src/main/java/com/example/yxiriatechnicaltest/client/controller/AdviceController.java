package com.example.yxiriatechnicaltest.client.controller;

import com.example.yxiriatechnicaltest.client.dto.ErrorMessage;
import com.example.yxiriatechnicaltest.client.dto.ErrorMessageBuilder;
import com.example.yxiriatechnicaltest.domain.exception.UserNotFoundException;
import com.example.yxiriatechnicaltest.domain.exception.UserReadNotAllowedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class AdviceController {
    @ExceptionHandler(value = {UserReadNotAllowedException.class})
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ErrorMessage handleErrorWhenConfigisFalse(UserReadNotAllowedException exception){
        return new ErrorMessageBuilder()
                .setDate(LocalDateTime.now())
                .setStatus(HttpStatus.FORBIDDEN)
                .setMessage(exception.getMessage())
                .createErrorMessage();
    }


    @ExceptionHandler(value = {UserNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleEuserNotFoundrrorWhenConfigisFalse(UserNotFoundException exception){
        return new ErrorMessageBuilder()
                .setDate(LocalDateTime.now())
                .setStatus(HttpStatus.NOT_FOUND)
                .setMessage(exception.getMessage())
                .createErrorMessage();
    }
}
