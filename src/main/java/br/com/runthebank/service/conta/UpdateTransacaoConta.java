package br.com.runthebank.service.conta;

import org.springframework.transaction.annotation.Transactional;

import br.com.runthebank.dao.ContaPessoaDao;
import br.com.runthebank.model.conta.Conta;
import br.com.runthebank.reposity.UpdateContaRepository;
import br.com.runthebank.utils.ContaUtils;

public class UpdateTransacaoConta implements IUpdateTransacaoConta{

	private UpdateContaRepository updateContaRepository;
	
	public UpdateTransacaoConta(UpdateContaRepository updateContaRepository) {
		this.updateContaRepository = updateContaRepository;
	}
	
	@Override
	@Transactional
	public boolean update(Conta contaRemetente, Conta ContaBenificiario) {

		ContaPessoaDao daoRemetente = conta2ContaPessoaDao(contaRemetente);
		ContaPessoaDao daoBeneficioario = conta2ContaPessoaDao(ContaBenificiario);
		
		updateDao(daoRemetente);
		updateDao(daoBeneficioario);
		
		return true;
	}
	
	private void updateDao(ContaPessoaDao dao)
	{
		ContaPessoaDao conta = updateContaRepository.getOne(dao.getId());
		conta.setSaldo(dao.getSaldo());
		dao.setSaldoIsNegative_Zero_Positive(dao.isSaldo_N_O_P());
		
		updateContaRepository.save(conta);
	}
	
	private ContaPessoaDao conta2ContaPessoaDao(Conta conta)
	{
		ContaPessoaDao dao = new ContaPessoaDao();
		
		dao.setId(conta.getId());
		dao.setSaldo(conta.getSaldo());
		dao.setSaldoIsNegative_Zero_Positive(ContaUtils.saldo_negative_zero_positive(conta.isSaldoState()));
		
		return dao;
	}

}
