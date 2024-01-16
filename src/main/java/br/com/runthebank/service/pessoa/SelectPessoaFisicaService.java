package br.com.runthebank.service.pessoa;

import java.util.List;

import br.com.runthebank.dao.PessoaFisicaDao;
import br.com.runthebank.reposity.ClientePessoaFisicaRepository;

public class SelectPessoaFisicaService implements ISelectPessoaFisicaService{

	private ClientePessoaFisicaRepository pfRepository;
	
	public SelectPessoaFisicaService(ClientePessoaFisicaRepository pfRepository)
	{
		this.pfRepository = pfRepository;
	}
	
	@Override
	public List<PessoaFisicaDao> buscarPessoaPf(String cpf) {
		// TODO Auto-generated method stub
		return pfRepository.findByCpf(cpf);
	}

}
