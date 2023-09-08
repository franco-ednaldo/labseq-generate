package com.example.labseq.adapter.in.controller;

import com.example.labseq.adapter.in.controller.mapper.LabSequenceMapper;
import com.example.labseq.adapter.in.controller.request.LabSequenceRequest;
import com.example.labseq.adapter.in.controller.response.LabSequenceResponse;
import com.example.labseq.application.port.in.GenerateSequenceInputPort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/labSeq")
public class LabSequenceController {
    private final GenerateSequenceInputPort generateSequenceInputPort;

    private final LabSequenceMapper labSequenceMapper;

    public LabSequenceController(GenerateSequenceInputPort generateSequenceInputPort, LabSequenceMapper labSequenceMapper) {
        this.generateSequenceInputPort = generateSequenceInputPort;
        this.labSequenceMapper = labSequenceMapper;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<LabSequenceResponse> getSequence(@Valid @RequestBody final LabSequenceRequest request) {
        final var labSequenceDomain = this.generateSequenceInputPort.generate(this.labSequenceMapper.toResponse(request));
        return ResponseEntity.ok().body(this.labSequenceMapper.toResponse(labSequenceDomain));
    }


}
