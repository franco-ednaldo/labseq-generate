package com.example.labseq.application.port.in;

import com.example.labseq.application.core.domain.LabSequenceDomain;

public interface GenerateSequenceInputPort {

    Long generate(LabSequenceDomain labSequenceDomain);

}
