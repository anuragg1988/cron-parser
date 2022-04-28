package com.company.exception;

public class InvalidOutPutException extends RuntimeException {
    public InvalidOutPutException(String message, Throwable ex){
        super(message,ex);
    }
    public InvalidOutPutException(String message){
        super(message);
    }
}
