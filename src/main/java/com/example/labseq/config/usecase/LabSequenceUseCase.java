package com.example.labseq.config.usecase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LabSequenceUseCase {
    @Bean
    public LabSequenceUseCase labSequenceUseCase(){
        return new LabSequenceUseCase();
    }
}
