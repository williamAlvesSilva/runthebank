package br.com.runthebank.service;

import org.springframework.stereotype.Service;

import br.com.runthebank.dao.PessoaFisicaDao;
import br.com.runthebank.dao.PessoaJuridicaDao;
import br.com.runthebank.model.Pessoa;
import br.com.runthebank.model.PessoaFisica;
import br.com.runthebank.model.PessoaJuridica;
import br.com.runthebank.reposity.ClientePessoaFisicaRepository;
import br.com.runthebank.reposity.ClientePessoaJuridicaRepository;

@Service
public class CadastrarPessoaJuridicaService implements ICadastrarPessoaService{

	private ClientePessoaJuridicaRepository pjRepository;
	
	public CadastrarPessoaJuridicaService(ClientePessoaJuridicaRepository pjRepository)
	{
		this.pjRepository = pjRepository;
	}
	
	@Override
	public boolean cadastrarPessoa(Pessoa pessoa) {
    	
		Boolean retorno = false;
		
    	try {
    		if(pessoa instanceof PessoaJuridica)
    		{
    			PessoaJuridica pf = (PessoaJuridica) pessoa;
		    	PessoaJuridicaDao pessoaJuridicaDao = new PessoaJuridicaDao();
		    	pessoaJuridicaDao.setCnpj(String.valueOf(pf.getCnpj()));
		    	pessoaJuridicaDao.setNome(pf.getNome());
		    	pessoaJuridicaDao.setEndereco(pf.getEndereco());
		    	    	
		    	pjRepository.save(pessoaJuridicaDao);
    		}
    		
    		retorno = true;
    	} catch (Exception e) {
			System.out.println("Erro ao insert pessoa fisica");
			retorno = false;
		} 
    	
    	return retorno;
    }

}
