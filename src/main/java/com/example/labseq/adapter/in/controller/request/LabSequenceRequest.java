package com.example.labseq.adapter.in.controller.request;

import jakarta.validation.constraints.NotNull;

public record LabSequenceRequest(
        @NotNull(message = "Number not found")
        Long number
) {

}
