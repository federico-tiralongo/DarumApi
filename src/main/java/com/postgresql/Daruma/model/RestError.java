package com.postgresql.Daruma.model;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class RestError {
    String status;
    String message;

    public RestError(HttpStatus status, String message) {
        this.status = status.toString();
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
