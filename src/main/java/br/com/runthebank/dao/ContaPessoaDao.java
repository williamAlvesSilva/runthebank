package br.com.runthebank.dao;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class ContaPessoaDao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
}
