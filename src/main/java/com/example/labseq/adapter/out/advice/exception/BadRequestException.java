package com.example.labseq.adapter.out.advice.exception;

public class BadRequestException extends RuntimeException {

    public BadRequestException(final String message, Throwable ex) {
        super(message, ex);
    }
    public BadRequestException(final String message) {
        super(message);
    }

    public BadRequestException() {
        super();
    }

}