package br.com.runthebank.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runthebank.dao.PessoaFisicaDao;
import br.com.runthebank.dao.PessoaJuridicaDao;
import br.com.runthebank.model.conta.TipoConta;
import br.com.runthebank.model.pessoa.Pessoa;
import br.com.runthebank.model.pessoa.PessoaFisica;
import br.com.runthebank.model.pessoa.PessoaJuridica;
import br.com.runthebank.reposity.ClientePessoaFisicaRepository;
import br.com.runthebank.reposity.ClientePessoaJuridicaRepository;
import br.com.runthebank.service.pessoa.CadastrarPessoaFisicaService;
import br.com.runthebank.service.pessoa.CadastrarPessoaJuridicaService;
import br.com.runthebank.service.pessoa.ICadastrarPessoaService;
import br.com.runthebank.service.pessoa.ISelectPessoaService;
import br.com.runthebank.service.pessoa.SelectPessoaFisicaService;
import br.com.runthebank.service.pessoa.SelectPessoaJuridicaService;
import br.com.runthebank.service.pessoa.SelectPessoaService;
import br.com.runthebank.utils.CPF_CNPJ_Utils;

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
			this.cadastrarPessoaService = new CadastrarPessoaFisicaService(pfRepository);
		}
		if(tipoConta == TipoConta.PJ)
		{
			this.cadastrarPessoaService = new CadastrarPessoaJuridicaService(pjRepository);
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
