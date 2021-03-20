package org.hananaharonof.payment.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(String msg, Object... args) {
        super(String.format(msg, args));
    }

    public static BadRequestException of(String msg, Object... args) {
        return new BadRequestException(msg, args);
    }
}
