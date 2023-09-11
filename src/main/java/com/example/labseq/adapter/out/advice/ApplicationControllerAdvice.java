package com.example.labseq.adapter.out.advice;

import com.example.labseq.adapter.out.advice.error.ApiErrors;
import com.example.labseq.adapter.out.advice.exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handleBusinessException(BadRequestException ex) {
        return new ApiErrors(ex);
    }


}