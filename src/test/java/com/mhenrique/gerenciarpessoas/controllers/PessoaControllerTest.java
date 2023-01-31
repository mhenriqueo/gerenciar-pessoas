package com.mhenrique.gerenciarpessoas.controllers;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mhenrique.gerenciarpessoas.models.Pessoa;
import com.mhenrique.gerenciarpessoas.services.PessoaService;

import jakarta.inject.Inject;

@SpringBootTest
@AutoConfigureMockMvc
public class PessoaControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PessoaService pessoaService;
	
	@Inject
	private ObjectMapper objectMapper;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void deveCadastrarUmaPessoa() throws Exception{
		var pessoa = new Pessoa();
		pessoa.setNome("Teste");
		
		doReturn(pessoa).when(pessoaService).cadastrarPessoa(Mockito.any());
		mockMvc.perform(post("/api/pessoas")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(pessoa)))				
				.andExpect(status().isCreated());
			
	}
	
	@Test
	public void deveEditarUmaPessoaPorId() throws Exception {
		var editarPessoa = new Pessoa();
		
		mockMvc.perform(put("/api/pessoas/{id}", 1L)
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(editarPessoa)))
				.andExpect(status().isOk());
	}
	
	@Test
	public void deveBuscarUmaPessoaPorId() throws Exception {	
		mockMvc.perform(get("/api/pessoas/{id}", 1L))
			.andExpect(status().isOk());
	}
	
	@Test
	public void deveRetornarUmaListaDePessoas() throws Exception {
		mockMvc.perform(get("/api/pessoas"))
			.andExpect(status().isOk());
	}
	
}
