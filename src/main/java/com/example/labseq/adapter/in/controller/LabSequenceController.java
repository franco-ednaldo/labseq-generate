package com.example.labseq.adapter.in.controller;

import com.example.labseq.adapter.out.advice.exception.BadRequestException;
import com.example.labseq.adapter.in.controller.response.LabSequenceResponse;
import com.example.labseq.application.core.domain.LabSequenceDomain;
import com.example.labseq.application.port.in.GenerateSequenceInputPort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/labSeq")
public class LabSequenceController {
    private final GenerateSequenceInputPort generateSequenceInputPort;

    public LabSequenceController(GenerateSequenceInputPort generateSequenceInputPort) {
        this.generateSequenceInputPort = generateSequenceInputPort;
    }

    @GetMapping("/{number}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(description = "Generate a sequence based in a number <number>value</number>.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sequence generated",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = LabSequenceResponse.class))}
            ),
            @ApiResponse(responseCode = "400", description = "Number must be positive number",
                    content = @Content()
            )
    })
    public ResponseEntity<LabSequenceResponse> getSequence(@PathVariable final Long number) {
        if (number < 0) throw new BadRequestException("Number must be positive number");
        final var result = this.generateSequenceInputPort.generate(new LabSequenceDomain(number));
        return ResponseEntity.ok().body(new LabSequenceResponse(result));
    }

}
