package com.example.labseq.adapter.in.controller;

import com.example.labseq.adapter.in.controller.response.LabSequenceResponse;
import com.example.labseq.application.core.domain.LabSequenceDomain;
import com.example.labseq.application.port.in.GenerateSequenceInputPort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

@SpringJUnitConfig
public class LabSequenceControllerTest {

    private MockMvc mockMvc;

    @Mock
    private GenerateSequenceInputPort generateSequenceInputPort;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = standaloneSetup(new LabSequenceController(generateSequenceInputPort)).build();
    }

    @Test
    public void testGetSequence() throws Exception {
        Long number = 5L; // Defina o número para teste
        Long expectedResult = 1L; // Defina o resultado esperado

        when(generateSequenceInputPort.generate(any(LabSequenceDomain.class))).thenReturn(expectedResult);

        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/labSeq/{number}", number)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String content = result.getResponse().getContentAsString();
        ResponseEntity<LabSequenceResponse> responseEntity = ResponseEntity.status(200)
                .body(new LabSequenceResponse(expectedResult));

        verify(generateSequenceInputPort, times(1)).generate(any(LabSequenceDomain.class));
    }
}
