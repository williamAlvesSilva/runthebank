package br.com.runthebank.service.conta;

import java.util.List;

import br.com.runthebank.dao.ContaPessoaDao;

public interface ISelectContaService {
	public List<ContaPessoaDao> getConta(String agencia);
}
