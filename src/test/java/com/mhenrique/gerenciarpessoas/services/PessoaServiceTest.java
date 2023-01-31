package com.mhenrique.gerenciarpessoas.services;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.mhenrique.gerenciarpessoas.models.Pessoa;
import com.mhenrique.gerenciarpessoas.repositories.PessoaRepository;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class PessoaServiceTest {

	@InjectMocks
	private PessoaService pessoaService;
	
	@Mock
	private PessoaRepository mockPessoaRepository;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}
	
	@Test
	public void deveCadastrarUmaPessoa(){
		var pessoa = new Pessoa();
		
		Mockito.doReturn(pessoa).when(mockPessoaRepository).save(Mockito.any());
		assertThat(pessoaService.cadastrarPessoa(pessoa)).isNotNull();
	}
	
	@Test
	public void deveEditarUmaPessoaPorId() {
		var editarPessoa = new Pessoa();
		var idPessoa = new Pessoa().getId();
		
		Mockito.doReturn(Optional.of(editarPessoa)).when(mockPessoaRepository).findById(idPessoa);
		Mockito.doReturn(editarPessoa).when(mockPessoaRepository).save(editarPessoa);
		assertThat(pessoaService.editarPessoaPorId(idPessoa, editarPessoa)).isNotNull();
		
	}
	
	@Test
	public void deveBuscarUmaPessoaPorId() {
		var idPessoa = new Pessoa().getId();
		
		Mockito.doReturn(pessoaService.consultarPessoaPorId(idPessoa)).when(mockPessoaRepository).findById(idPessoa);
	}
	
	@Test
	public void deveRetornarUmaListaDePessoas() {
		var pessoa = new ArrayList<Pessoa>();
		
		Mockito.doReturn(pessoa).when(mockPessoaRepository).findAll();
	}
	
}
