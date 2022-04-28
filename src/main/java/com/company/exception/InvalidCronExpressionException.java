package com.company.exception;

public class InvalidCronExpressionException extends RuntimeException {
    public InvalidCronExpressionException(String message, Throwable ex){
        super(message,ex);
    }

    public InvalidCronExpressionException(String message){
        super(message);
    }
}
