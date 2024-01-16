package br.com.runthebank.service.conta;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import br.com.runthebank.dao.ContaPessoaDao;
import br.com.runthebank.dao.PessoaFisicaDao;
import br.com.runthebank.model.conta.Conta;
import br.com.runthebank.model.conta.SaldoState;
import br.com.runthebank.model.conta.StatusConta;
import br.com.runthebank.model.conta.TipoConta;
import br.com.runthebank.model.pessoa.Pessoa;
import br.com.runthebank.model.pessoa.PessoaFisica;
import br.com.runthebank.reposity.ContaRepository;

public class CadastrarContaPessoaService implements CadastrarContaService {

	private ContaRepository contaRepository;
	
	public CadastrarContaPessoaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
	
	@Override
	public int cadastrarConta(Conta conta) {
		int retorno = -1;
    	
    	try {
    		ContaPessoaDao contaDao = new ContaPessoaDao();
    		contaDao.setAgenciaKeyID(String.valueOf(conta.getAgencia()));
    		contaDao.setClientPF(conta.getTipoConta() == TipoConta.PF ? true : false);
    		
    		if(conta.getPessoaCliente() == null) {
    			throw new IOException("Pessoa cliente não pode ser null.");
    		}
    		
    		Pessoa pessoa = conta.getPessoaCliente().get(0);
    		contaDao.setOwnerClientId(pessoa != null ? pessoa.getId() : 0);
    		
    		if(contaDao.getOwnerClientId() == 0)
    		{
    			throw new IOException("Pessoa cliente obrigatoriamente deve ter ID.");
    		}
    		
    		contaDao.setSaldo(conta.getSaldo());
    		contaDao.setSaldoIsNegative_Zero_Positive(saldo_negative_zero_positive(conta.isSaldoState()));
    		contaDao.setStatus(conta.getStatus() == StatusConta.ATIVA ? 1 : 0);
    		
    		contaRepository.save(contaDao);
    		
    		retorno = 0;
    		
	        return retorno;
    	} catch (DataIntegrityViolationException dataEx)
    	{
    		System.out.println("Erro violação da integridade dos dados.");
    		retorno = 1;
    	}
    	catch (Exception e) {
			System.out.println("Erro ao insert pessoa fisica");
			retorno = 2;
		}
    	
		return retorno;
	}
	
	private String saldo_negative_zero_positive(SaldoState state)
	{
		String retorno = "";
		switch(state)
		{
		case NEGATIVE:
			retorno = "-";
			break;
		case ZERO:
			retorno = "0";
			break;
		case POSITIVE:
			retorno = "+";
			break;
		}
		
		return retorno;
	}
}
