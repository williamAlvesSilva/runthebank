package br.com.runthebank.service.pessoa;

import br.com.runthebank.dao.PessoaFisicaDao;
import br.com.runthebank.model.pessoa.Pessoa;
import br.com.runthebank.model.pessoa.PessoaFisica;
import br.com.runthebank.model.pessoa.PessoaJuridica;
import br.com.runthebank.reposity.ClientePessoaFisicaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastrarPessoaFisicaService implements ICadastrarPessoaService{

	private ClientePessoaFisicaRepository pfRepository;
	
	public CadastrarPessoaFisicaService(ClientePessoaFisicaRepository pfRepository)
	{
		this.pfRepository = pfRepository;
	}
	
    public boolean cadastrarPessoa(Pessoa pessoa) {
    	
    	Boolean retorno = false;
    	
    	try {
    		if(pessoa instanceof PessoaFisica)
    		{
    			PessoaFisica pf = (PessoaFisica) pessoa;
		    	PessoaFisicaDao pessoaFisicaDao = new PessoaFisicaDao();
		    	pessoaFisicaDao.setCpf(String.valueOf(pf.getCpf()));
		    	pessoaFisicaDao.setNome(pf.getNome());
		    	pessoaFisicaDao.setEndereco(pf.getEndereco());
		    	    	
		    	pfRepository.save(pessoaFisicaDao);
    		}
    		
    		retorno = true;
    		
	        return retorno;
    	} catch (Exception e) {
			System.out.println("Erro ao insert pessoa fisica");
			retorno = false;
		}
			return retorno;
		}
}
