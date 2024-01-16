package br.com.runthebank.service.conta;

import br.com.runthebank.model.conta.Conta;

public interface IUpdateTransacaoConta {
	public boolean update(Conta contaRemetente, Conta ContaBenificiario);
}
