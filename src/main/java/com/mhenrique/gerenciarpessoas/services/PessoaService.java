package com.mhenrique.gerenciarpessoas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mhenrique.gerenciarpessoas.models.Pessoa;
import com.mhenrique.gerenciarpessoas.repositories.PessoaRepository;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Pessoa cadastrarPessoa(Pessoa pessoa){
		return pessoaRepository.save(pessoa);
	}
	
	public Pessoa editarPessoaPorId(Long id, Pessoa editarPessoa) {
		var buscarPessoa = pessoaRepository.findById(id).get();
		editarPessoa.setId(buscarPessoa.getId());
		return pessoaRepository.save(editarPessoa);
}
	
	public Optional<Pessoa> consultarPessoaPorId(Long id) {
		return pessoaRepository.findById(id);
	}
	
	public List<Pessoa> consultarListaDePessoas() {
		return pessoaRepository.findAll();
	}
	
}
