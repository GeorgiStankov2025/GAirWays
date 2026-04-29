package com.georgistankov.gairways.Exceptions;

public class ResourceNotFoundException extends RuntimeException
{
    public ResourceNotFoundException(String message)
    {
        super(message);
    }
}
