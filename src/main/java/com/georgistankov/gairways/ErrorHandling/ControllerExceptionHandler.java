package com.georgistankov.gairways.ErrorHandling;

import com.georgistankov.gairways.Exceptions.BadRequestException;
import com.georgistankov.gairways.Exceptions.ConflictException;
import com.georgistankov.gairways.Exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.naming.AuthenticationException;
import java.time.Instant;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError handleNotFound(ResourceNotFoundException ex, HttpServletRequest req) {
        return new ApiError(
                "Resource Not Found",
                404,
                ex.getMessage(),
                req.getRequestURI(),
                Instant.now()
        );
    }
    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ApiError handleConflict(ConflictException ex, HttpServletRequest req) {
        return new ApiError(
                "Request content conflicts with another existing resource",
                409,
                ex.getMessage(),
                req.getRequestURI(),
                Instant.now()
        );
    }
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleBadCredentials(BadCredentialsException ex, HttpServletRequest req) {
        return new ApiError(
                "Invalid login credentials",
                400,
                ex.getMessage(),
                req.getRequestURI(),
                Instant.now()
        );
    }
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleBadRequest(BadRequestException ex, HttpServletRequest req) {
        return new ApiError(
                "Invalid request data",
                400,
                ex.getMessage(),
                req.getRequestURI(),
                Instant.now()
        );
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiError handleGeneric(Exception ex, HttpServletRequest req) {
        return new ApiError(
                "Internal Server Error",
                500,
                "An unexpected error occurred",
                req.getRequestURI(),
                Instant.now()
        );
    }

}
