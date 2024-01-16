package br.com.runthebank.service.pessoa;

import java.util.List;

import br.com.runthebank.dao.PessoaFisicaDao;
import br.com.runthebank.dao.PessoaJuridicaDao;

public interface ISelectPessoaService {
	public List<PessoaFisicaDao> buscarPessoaPf(String cpf_cnpj);
	public List<PessoaJuridicaDao> buscarPessoaPj(String cpf_cnpj);
}
