package com.example.labseq.application.port.in;

import com.example.labseq.application.core.domain.LabSequenceDomain;

public interface GenerateSequenceInputPort {

    LabSequenceDomain generate(LabSequenceDomain labSequenceDomain);

}
