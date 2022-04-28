package com.company.exception;

public class InvalidOutPutHandlerException extends RuntimeException {
    public InvalidOutPutHandlerException(String message, Throwable ex){
        super(message,ex);
    }
}
