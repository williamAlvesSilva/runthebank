package br.com.runthebank.factory;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.runthebank.dao.ContaPessoaDao;
import br.com.runthebank.model.conta.Conta;
import br.com.runthebank.reposity.UpdateContaRepository;
import br.com.runthebank.service.conta.SelectContaService;
import br.com.runthebank.utils.ContaUtils;
import br.com.runthebank.service.conta.IUpdateTransacaoConta; 
import br.com.runthebank.service.conta.UpdateTransacaoConta; 

@Service
public class TransferenciaFactory 
{
	@Autowired
	private UpdateContaRepository updateContaRepository;

	public List<Conta> getConta(String agencia) {
		SelectContaService contaService = new SelectContaService(updateContaRepository);
		List<ContaPessoaDao> contaDaoList  = contaService.getConta(agencia);
		List<Conta> contaList = new ArrayList<Conta>();
		
		for(ContaPessoaDao contaDao : contaDaoList)
		{
			Conta conta = new Conta();
			conta.setId(contaDao.getId());
			conta.setAgencia(Long.parseLong(contaDao.getAgenciaKeyID()));
			
			conta.setSaldo(contaDao.getSaldo());
			conta.setSaldoState(ContaUtils.saldo_negative_zero_positive2SaldoState(contaDao.isSaldo_N_O_P()));
			
			contaList.add(conta);
		}
		
		return contaList;
	}
	
	public boolean updateTransacao(Conta contaRemetente,  Conta contaBeneficiario)
	{
		IUpdateTransacaoConta update = new UpdateTransacaoConta(updateContaRepository);
		
		return update.update(contaRemetente, contaBeneficiario);
	}

	public UpdateContaRepository getUpdateContaRepository() {
		return updateContaRepository;
	}

	public void setUpdateContaRepository(UpdateContaRepository updateContaRepository) {
		this.updateContaRepository = updateContaRepository;
	}
}
