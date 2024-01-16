package br.com.runthebank.service.conta;

import java.util.List;

import br.com.runthebank.dao.ContaPessoaDao;
import br.com.runthebank.reposity.UpdateContaRepository;

public class SelectContaService implements ISelectContaService{

	private UpdateContaRepository updateContaRepository;
	
	public SelectContaService(UpdateContaRepository updateContaRepository) {
		this.updateContaRepository = updateContaRepository;
	}
	
	@Override
	public List<ContaPessoaDao> getConta(String agencia) {
		return updateContaRepository.findByAgenciaKeyID(agencia);
	}

}
