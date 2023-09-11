package com.example.labseq.application.core.usecase;


import com.example.labseq.application.core.domain.CacheSeq;
import com.example.labseq.application.core.domain.LabSequenceDomain;
import com.example.labseq.application.port.in.GenerateSequenceInputPort;

public class LabSequenceUseCase implements GenerateSequenceInputPort {
    private  final CacheSeq cache;

    public LabSequenceUseCase(CacheSeq cache) {
        this.cache = cache;
    }

    @Override
    public Long generate(LabSequenceDomain input) {
        if (cache.containsKey(input.number())) {
            return cache.get(input.number());
        }

        if (input.number() == 0 || input.number() == 2) {
            return 0l;
        } else if (input.number() == 1 || input.number() == 3) {
            return 1l;
        } else {
            Long value = generate(new LabSequenceDomain(input.number() - 4)) + generate(new LabSequenceDomain(input.number() - 3));
            cache.put(input.number(), value );
            return value;
        }

    }
}
