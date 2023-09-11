package com.example.labseq.config.usecase;

import com.example.labseq.application.core.domain.CacheSeq;
import com.example.labseq.application.core.usecase.LabSequenceUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LabSequenceUseCaseConfig {
    @Bean
    public LabSequenceUseCase labSequenceUseCase(){
        return new LabSequenceUseCase(new CacheSeq());
    }
}
