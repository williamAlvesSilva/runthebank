package br.com.runthebank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.runthebank.factory.ContaCriarFactory;
import br.com.runthebank.factory.SelectClientePessoa;
import br.com.runthebank.model.DTO.ContaDTO;
import br.com.runthebank.model.conta.Conta;
import br.com.runthebank.model.conta.StatusConta;
import br.com.runthebank.model.pessoa.Pessoa;
import br.com.runthebank.service.conta.CadastrarContaService;
import br.com.runthebank.utils.CPF_CNPJ_Utils;
import br.com.runthebank.utils.ContaUtils;
import br.com.runthebank.utils.SaldoUtils;

@RestController
public class ContaController {
	
	@Autowired
	private ContaCriarFactory contaCriarfactory;
	
	@Autowired
	private SelectClientePessoa selectClientePessoaFectory;
	
	@PostMapping("/api/criar_conta")
    public String criarConta(@RequestBody ContaDTO contaDTO) {
    	
    	String mensagem = "";
    	
    	Conta conta = converterDTO2Conta(contaDTO);
    	
    	List<Pessoa> pessoaList = selectClientePessoaFectory.getSelectPessoaService(contaDTO.getCpf_cnpj());
    	
    	if(existeCadastroPessoaCliente(pessoaList))
    	{
    		mensagem = "Cliente não localizado, favor criar ou verificar.";
    		return mensagem;
    	}
    	
    	conta.setPessoaCliente(pessoaList);
    	
    	CadastrarContaService cadastrarConta = this.contaCriarfactory.configureCadastrarPessoaService(conta.getTipoConta());
    	int retorno2mgs = cadastrarConta.cadastrarConta(conta);
    	if(retorno2mgs == 0)
    	{
    		mensagem = "Conta criada realizado com sucesso!!!";
    	} else if(retorno2mgs == 1){ 
    		mensagem = "Agencia já cadastrada, tente outra.";
    	} else {
    		mensagem = "Criacao da conta deu erro!!!";
    	}
        
        return mensagem;
    }
	
	private boolean existeCadastroPessoaCliente(List<Pessoa> pessoaList)
	{
		return pessoaList.isEmpty();
	}
	
	private Conta converterDTO2Conta(ContaDTO contaDTO) {
		
		Conta conta = new Conta();
		conta.setAgencia(ContaUtils.STRING_2_LONG(contaDTO.getAgencia()));
		conta.setSaldo(ContaUtils.STRING_2_INT(contaDTO.getSaldo()));
		conta.setSaldoState(SaldoUtils.sigNumber(contaDTO.getSaldo()));
		conta.setStatus(contaDTO.getStatus().toUpperCase().contains("ATIVA") ? StatusConta.ATIVA : StatusConta.INATIVA);
		
		conta.setTipoConta(CPF_CNPJ_Utils.isClientePFByCPF(contaDTO.getCpf_cnpj()));

		return conta;
	}

	public SelectClientePessoa getSelectClientePessoa() {
		return selectClientePessoaFectory;
	}

	public void setSelectClientePessoa(SelectClientePessoa selectClientePessoaFectory) {
		this.selectClientePessoaFectory = selectClientePessoaFectory;
	}

	public ContaCriarFactory getContaCriarfactory() {
		return contaCriarfactory;
	}

	public void setContaCriarfactory(ContaCriarFactory contaCriarfactory) {
		this.contaCriarfactory = contaCriarfactory;
	}
}
