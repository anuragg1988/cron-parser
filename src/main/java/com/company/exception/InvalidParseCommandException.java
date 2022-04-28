package com.company.exception;

public class InvalidParseCommandException extends RuntimeException {
    public InvalidParseCommandException(String message, Throwable ex){
        super(message,ex);
    }

    public InvalidParseCommandException(String message){
        super(message);
    }
}
