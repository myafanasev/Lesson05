package ru.dl.exception;

// исключение для ошибок типа 404/Not found
public class ExceptionNotFound extends RuntimeException{
    public ExceptionNotFound(String message) {
        super(message);
    }
}
