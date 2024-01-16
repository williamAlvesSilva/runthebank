package br.com.runthebank.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runthebank.model.conta.TipoConta;
import br.com.runthebank.reposity.ContaRepository;
import br.com.runthebank.service.conta.CadastrarContaPessoaService;
import br.com.runthebank.service.conta.CadastrarContaService;

@Service
public class ContaCriarFactory {
	
	@Autowired
	private ContaRepository contaRepository;
	
	private CadastrarContaService contaPessoaService;

	public CadastrarContaService configureCadastrarPessoaService(TipoConta tipoConta) {
		
		if(tipoConta.PF == tipoConta)
		{
			contaPessoaService = new CadastrarContaPessoaService(contaRepository);
		}
		else if(tipoConta.PJ == tipoConta)
		{
			contaPessoaService = new CadastrarContaPessoaService(contaRepository);
		} else {
			contaPessoaService = new CadastrarContaPessoaService(contaRepository);
		}
		
		return contaPessoaService;
	}
	
	public ContaRepository getContaRepository() {
		return contaRepository;
	}

	public void setContaRepository(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
	
	
}
