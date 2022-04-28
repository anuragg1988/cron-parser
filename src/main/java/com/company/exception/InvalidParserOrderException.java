package com.company.exception;

public class InvalidParserOrderException extends RuntimeException {
    public InvalidParserOrderException(String message, Throwable ex){
        super(message,ex);
    }

    public InvalidParserOrderException(String message){
        super(message);
    }
}
