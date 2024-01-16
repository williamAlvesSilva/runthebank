package br.com.runthebank.service.pessoa;

import java.util.List;

import br.com.runthebank.dao.PessoaJuridicaDao;

public interface ISelectPessoaJuridicaService {
	public List<PessoaJuridicaDao> buscarPessoaPj(String cnpj);
}
