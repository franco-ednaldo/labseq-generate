package com.example.labseq.application.core.usecase;

import com.example.labseq.application.core.domain.CacheSeq;
import com.example.labseq.application.core.domain.LabSequenceDomain;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LabSequenceUseCaseTest {
    private LabSequenceUseCase labSequenceUseCase;

    @BeforeEach
    void init() {
        final var cache = new CacheSeq();
        this.labSequenceUseCase = new LabSequenceUseCase(cache);
    }


    @Test
    public void testCalculateLabSeqForZero() {
        long result = labSequenceUseCase.generate(new LabSequenceDomain(0l));
        assertEquals(0, result);
    }

    @Test
    public void testCalculateLabSeqForOne() {
        long result = labSequenceUseCase.generate(new LabSequenceDomain(1l));
        assertEquals(1, result);
    }

    @Test
    public void testCalculateLabSeqForTwo() {
        long result = labSequenceUseCase.generate(new LabSequenceDomain(2l));
        assertEquals(0, result);
    }

    @Test
    public void testCalculateLabSeqForThree() {
        long result = labSequenceUseCase.generate(new LabSequenceDomain(3l));
        assertEquals(1, result);
    }

    @Test
    public void testCalculateLabSeqForFour() {
        long result = labSequenceUseCase.generate(new LabSequenceDomain(4l));
        assertEquals(1, result);
    }

    @Test
    public void testCalculateLabSeqForFive() {
        long result = labSequenceUseCase.generate(new LabSequenceDomain(5l));
        assertEquals(1, result);
    }
}