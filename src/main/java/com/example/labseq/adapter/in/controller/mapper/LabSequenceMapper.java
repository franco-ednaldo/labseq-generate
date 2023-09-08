package com.example.labseq.adapter.in.controller.mapper;

import com.example.labseq.adapter.in.controller.request.LabSequenceRequest;
import com.example.labseq.adapter.in.controller.response.LabSequenceResponse;
import com.example.labseq.application.core.domain.LabSequenceDomain;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LabSequenceMapper {

    LabSequenceDomain toResponse(LabSequenceRequest labSequenceRequest);

    LabSequenceResponse toResponse(LabSequenceDomain labSequenceDomain);
}
