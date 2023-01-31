package com.mhenrique.gerenciarpessoas.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mhenrique.gerenciarpessoas.models.Pessoa;
import com.mhenrique.gerenciarpessoas.services.PessoaService;

@RestController
@RequestMapping("/api")
public class PessoaController {
	
	@Autowired
	private PessoaService pessoaService;
	
	@PostMapping("/pessoas")
	public ResponseEntity<Pessoa> cadastrarPessoa(@RequestBody Pessoa pessoa) {
		var pessoaCadastrada = pessoaService.cadastrarPessoa(pessoa);		
		return ResponseEntity.created(URI.create(String.format("/pessoas/%s", pessoaCadastrada.getNome()))).body(pessoaCadastrada);
	}
	
	@PutMapping("/pessoas/{id}")
	public ResponseEntity<Pessoa> editarPessoaPorId(@PathVariable Long id, @RequestBody Pessoa editarPessoa) {		
		return ResponseEntity.ok(pessoaService.editarPessoaPorId(id, editarPessoa));
	}
	
	@GetMapping("/pessoas/{id}")
	public ResponseEntity<Optional<Pessoa>> consultarPessoaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(pessoaService.consultarPessoaPorId(id));
	}
	
	@GetMapping("/pessoas")
	public ResponseEntity<List<Pessoa>> consultarListaDePessoas() {	
		return ResponseEntity.ok(pessoaService.consultarListaDePessoas());
	}
}
