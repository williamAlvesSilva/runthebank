package br.com.runthebank.service.pessoa;

import java.util.List;

import br.com.runthebank.dao.PessoaFisicaDao;

public interface ISelectPessoaFisicaService {
	public List<PessoaFisicaDao> buscarPessoaPf(String cpf);
}
