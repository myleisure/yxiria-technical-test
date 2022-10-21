package com.example.yxiriatechnicaltest.client.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorMessageBuilder {
    private String message;
    private LocalDateTime date;
    private HttpStatus status;

    public ErrorMessageBuilder setMessage(String message) {
        this.message = message;
        return this;
    }

    public ErrorMessageBuilder setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public ErrorMessageBuilder setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ErrorMessage createErrorMessage() {
        return new ErrorMessage(message, date, status);
    }
}