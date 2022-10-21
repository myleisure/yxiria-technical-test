package com.example.yxiriatechnicaltest.client.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class ErrorMessage {
    private String message;
    private LocalDateTime date;
    private HttpStatus status;

    public ErrorMessage(String message, LocalDateTime date, HttpStatus status) {
        this.message = message;
        this.date = date;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
