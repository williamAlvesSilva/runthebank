package br.com.runthebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.runthebank.factory.SelectClientePessoa;
import br.com.runthebank.factory.TransferenciaFactory;
import br.com.runthebank.model.DTO.TransferenciaDTO;
import br.com.runthebank.model.conta.Conta;
import br.com.runthebank.model.transferencia.Transferencia;
import br.com.runthebank.utils.SaldoUtils;

@Transactional
@RestController
public class TransferenciaController {

	@Autowired
	private SelectClientePessoa selectClientePessoaFectory;
	
	@PostMapping("/api/transferencia")
    public String transferencia(@RequestBody TransferenciaDTO transfDTO) {
		
		Transferencia transferencia = new Transferencia();
		transferencia.setAgenciaBeneficio(transfDTO.getAgenciaBeneficio());
		
		transferencia.setAgenciaRemetente(transfDTO.getAgenciaRemetente());
		transferencia.setValorTransferencia(Integer.parseInt(transfDTO.getValorTransferencia()));
		
		
		TransferenciaFactory tFacture = new TransferenciaFactory();
		List<Conta> listaConta = tFacture.getConta(transferencia.getAgenciaRemetente());
		
		Conta conta = listaConta.get(0);
		
		if(conta.getSaldo() < transferencia.getValorTransferencia())
		{
			return "Valor superior ao saldo do usuario: " + transferencia.getAgenciaRemetente();
		}
		
		List<Conta> listaContaBeneficiario = tFacture.getConta(transferencia.getAgenciaBeneficio());
		
		if(listaContaBeneficiario == null)
		{
			return "Usuario: " + transferencia.getAgenciaRemetente() + " não existe";
		}
		
		Conta contaBenefiario = listaConta.get(0);
		
		if(contaBenefiario == null)
		{
			return "Usuario: " + transferencia.getAgenciaRemetente() + " não existe";
		}
		
		int saldoRemanecente = conta.getSaldo() - transferencia.getValorTransferencia();
		int saldoAtualizadoBeneficiario = contaBenefiario.getSaldo() + transferencia.getValorTransferencia();
		
		conta.setSaldo(saldoRemanecente);
		conta.setSaldoState(SaldoUtils.sigNumber(saldoRemanecente));

		contaBenefiario.setSaldo(saldoAtualizadoBeneficiario);
		contaBenefiario.setSaldoState(SaldoUtils.sigNumber(saldoRemanecente));
		
		boolean retorno = tFacture.updateTransacao(conta, contaBenefiario);
		
		if(retorno == true)
		{
			return "Transferencia com sucesso!!!";
		} else {
			return "Transferencia deu ruim!!!";
		}
		
	}
	
	
}
