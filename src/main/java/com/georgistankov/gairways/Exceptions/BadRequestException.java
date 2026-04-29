package com.georgistankov.gairways.Exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException(String message){
        super(message);
    }
}
