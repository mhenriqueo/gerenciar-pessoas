package com.mhenrique.gerenciarpessoas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mhenrique.gerenciarpessoas.models.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long>{
	
}