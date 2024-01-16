package br.com.runthebank.service.pessoa;

import java.util.List;

import br.com.runthebank.dao.PessoaFisicaDao;
import br.com.runthebank.dao.PessoaJuridicaDao;

public class SelectPessoaService implements ISelectPessoaService {

	private SelectPessoaFisicaService selectPessoaFisicaService;
	private SelectPessoaJuridicaService selectPessoaJuridicaService;
	
	public SelectPessoaService(SelectPessoaFisicaService selectPessoaFisicaService)
	{
		this.selectPessoaFisicaService = selectPessoaFisicaService;
	}
	
	public SelectPessoaService(SelectPessoaJuridicaService selectPessoaJuridicaService)
	{
		this.selectPessoaJuridicaService = selectPessoaJuridicaService;
	}
	
	@Override
	public List<PessoaFisicaDao> buscarPessoaPf(String cpf_cnpj) {
		
		if(this.selectPessoaJuridicaService != null)
		{
			return null;
		}
		
		return selectPessoaFisicaService.buscarPessoaPf(cpf_cnpj);
	}

	@Override
	public List<PessoaJuridicaDao> buscarPessoaPj(String cpf_cnpj) {
		
		if(this.selectPessoaFisicaService != null)
		{
			return null;
		}
		
		return selectPessoaJuridicaService.buscarPessoaPj(cpf_cnpj);
	}

}
