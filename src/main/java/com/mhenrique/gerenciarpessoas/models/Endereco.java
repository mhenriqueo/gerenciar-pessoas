package com.mhenrique.gerenciarpessoas.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_endereco")
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String cep;

	@Column
	private String logradouro;
	
	@Column
	private String numero;
	
	@Column
	private String cidade;
	
	@Column
	private boolean enderecoPrincipal;
	
}
