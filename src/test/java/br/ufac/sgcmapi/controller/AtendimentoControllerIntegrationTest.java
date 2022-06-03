package br.ufac.sgcmapi.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import br.ufac.sgcmapi.repository.AtendimentoRepository;

@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class AtendimentoControllerIntegrationTest {

    private final MockMvc mock;
    private final AtendimentoRepository repo;
    
    @Autowired
    public AtendimentoControllerIntegrationTest(MockMvc mock, AtendimentoRepository repo) {
        this.mock = mock;
        this.repo = repo;
    }

    @Test
    @WithMockUser
    public void testGetAll() throws Exception {
        mock.perform(MockMvcRequestBuilders.get("/atendimento/")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasSize(5)));
    }
    
}
