package br.com.runthebank.service.pessoa;

import java.util.List;

import br.com.runthebank.dao.PessoaJuridicaDao;
import br.com.runthebank.reposity.ClientePessoaJuridicaRepository;

public class SelectPessoaJuridicaService implements ISelectPessoaJuridicaService{

	private ClientePessoaJuridicaRepository pjRepository;
	
	public SelectPessoaJuridicaService(ClientePessoaJuridicaRepository pjRepository)
	{
		this.pjRepository = pjRepository;
	}
	@Override
	public List<PessoaJuridicaDao> buscarPessoaPj(String cnpj) {
		// TODO Auto-generated method stub
		return pjRepository.findByCnpj(cnpj);
	}

}
