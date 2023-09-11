package com.example.labseq.adapter.out.advice.error;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApiErrors {
    private List<String> erros;

    public ApiErrors(BindingResult bindingResult) {
        this.erros = new ArrayList<>();
        bindingResult.getAllErrors().forEach(error -> this.erros.add(error.getDefaultMessage()));
    }

    public ApiErrors(Exception exception) {
        this.erros = Arrays.asList(exception.getMessage());
    }

    public List<String> getErrors() {
        return erros;
    }
}