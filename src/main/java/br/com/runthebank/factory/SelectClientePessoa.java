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
import br.com.runthebank.service.pessoa.ISelectPessoaService;
import br.com.runthebank.service.pessoa.SelectPessoaFisicaService;
import br.com.runthebank.service.pessoa.SelectPessoaJuridicaService;
import br.com.runthebank.service.pessoa.SelectPessoaService;
import br.com.runthebank.utils.CPF_CNPJ_Utils;

@Service
public class SelectClientePessoa {

	private ISelectPessoaService selectPessoaService;
	
	@Autowired
	private ClientePessoaFisicaRepository pfRepository;
	
	@Autowired
	private ClientePessoaJuridicaRepository pjRepository;
	
	private void configureSelectPessoaService(TipoConta tipoConta)
	{
		if(tipoConta == TipoConta.PF)
		{
			SelectPessoaFisicaService selectPF = new SelectPessoaFisicaService(pfRepository);
			this.selectPessoaService = new SelectPessoaService(selectPF);
		}
		if(tipoConta == TipoConta.PJ)
		{
			SelectPessoaJuridicaService selectPF = new SelectPessoaJuridicaService(pjRepository);
			this.selectPessoaService = new SelectPessoaService(selectPF);
		}
	}
	
	public List<Pessoa> getSelectPessoaService(String cpf_cnpj)
	{
		TipoConta tipoConta = CPF_CNPJ_Utils.isClientePFByCPF(cpf_cnpj);
		configureSelectPessoaService(tipoConta);
		
		List<Pessoa> pessoaList = new ArrayList<Pessoa>();
		
		cpf_cnpj = CPF_CNPJ_Utils.returnJustNumbers(cpf_cnpj);
		
		if(tipoConta == TipoConta.PF)
		{
			List<PessoaFisicaDao> pessoaFisicaDao = this.selectPessoaService.buscarPessoaPf(cpf_cnpj);
			
			
			for(PessoaFisicaDao pessoaDao : pessoaFisicaDao)
			{
				PessoaFisica pf = new PessoaFisica();
				pf.setId(pessoaDao.getId());
				pf.setNome(pessoaDao.getNome());
				pf.setEndereco(pessoaDao.getEndereco());
				pf.setCpf(Long.parseLong(pessoaDao.getCpf()));
				
				pessoaList.add(pf);
			}
			
			return pessoaList;
		} else {
			List<PessoaJuridicaDao> pessoaJuridicaDao = this.selectPessoaService.buscarPessoaPj(cpf_cnpj);
			
			for(PessoaJuridicaDao pessoaDao : pessoaJuridicaDao)
			{
				PessoaJuridica pf = new PessoaJuridica();
				pf.setId(pessoaDao.getId());
				pf.setNome(pessoaDao.getNome());
				pf.setEndereco(pessoaDao.getEndereco());
				pf.setCnpj(Long.parseLong(pessoaDao.getCnpj()));
				
				pessoaList.add(pf);
			}
			
			return pessoaList;
		}
	}
	
	

	public ClientePessoaFisicaRepository getPfRepository() {
		return pfRepository;
	}

	public void setPfRepository(ClientePessoaFisicaRepository pfRepository) {
		this.pfRepository = pfRepository;
	}

	public ClientePessoaJuridicaRepository getPjRepository() {
		return pjRepository;
	}

	public void setPjRepository(ClientePessoaJuridicaRepository pjRepository) {
		this.pjRepository = pjRepository;
	}
}
