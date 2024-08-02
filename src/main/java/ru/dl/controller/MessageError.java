package ru.dl.controller;

import lombok.Data;
import org.springframework.http.HttpStatusCode;

import java.util.Map;

// для формирования текста ошибки
@Data
public class MessageError {
    private int status;
    private HttpStatusCode statusCode;
    private String message;
    private Map<String, String> errors; // список ошибок

    public MessageError(int status, HttpStatusCode statusCode, String message, Map<String, String> errors) {
        this.status = status;
        this.statusCode = statusCode;
        this.message = message;
        this.errors = errors;
    }
}
