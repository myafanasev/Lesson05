package ru.dl.exception;

// исключение для ошибок типа 400/Bad Request
public class ExceptionBadRequest extends RuntimeException
{
    public ExceptionBadRequest(String message) {
        super(message);
    }
}