package org.hananaharonof.payment.configuration;

import org.hananaharonof.payment.exception.BadRequestException;
import org.hananaharonof.payment.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HttpErrorHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handle(BadRequestException e) {
        return e.getMessage();
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handle(NotFoundException e) {
        return e.getMessage();
    }

}
