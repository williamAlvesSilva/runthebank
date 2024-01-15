package br.com.runthebank.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runthebank.model.TipoConta;
import br.com.runthebank.reposity.ClientePessoaFisicaRepository;
import br.com.runthebank.reposity.ClientePessoaJuridicaRepository;
import br.com.runthebank.service.CadastrarPessoaFisicaService;
import br.com.runthebank.service.CadastrarPessoaJuridicaService;
import br.com.runthebank.service.ICadastrarPessoaService;

@Service
public class ClientePessoaFactory {

	@Autowired
	private ClientePessoaFisicaRepository pfRepository;
	
	@Autowired
	private ClientePessoaJuridicaRepository pjRepository;
	
	private ICadastrarPessoaService cadastrarPessoaService;
	

	
	private void configureCadastrarPessoaService(TipoConta tipoConta)
	{
		if(tipoConta == TipoConta.PF)
		{
			this.cadastrarPessoaService = new CadastrarPessoaFisicaService(getPfRepository());
		}
		if(tipoConta == TipoConta.PJ)
		{
			this.cadastrarPessoaService = new CadastrarPessoaJuridicaService(getPjRepository());
		}
	}
	
	public ICadastrarPessoaService getCadastrarPessoaService(TipoConta tipoConta)
	{
		configureCadastrarPessoaService(tipoConta);
		
		return this.cadastrarPessoaService;
	}

	public ClientePessoaJuridicaRepository getPjRepository() {
		return pjRepository;
	}

	public void setPjRepository(ClientePessoaJuridicaRepository pjRepository) {
		this.pjRepository = pjRepository;
	}

	public ClientePessoaFisicaRepository getPfRepository() {
		return pfRepository;
	}

	public void setPfRepository(ClientePessoaFisicaRepository pfRepository) {
		this.pfRepository = pfRepository;
	}
}
