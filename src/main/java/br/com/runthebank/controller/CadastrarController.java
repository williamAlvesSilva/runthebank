package br.com.runthebank.controller;

import br.com.runthebank.factory.ClientePessoaFactory;
import br.com.runthebank.model.Pessoa;
import br.com.runthebank.model.PessoaFisica;
import br.com.runthebank.model.PessoaJuridica;
import br.com.runthebank.model.TipoConta;
import br.com.runthebank.model.DTO.ClientePessoaDTO;
import br.com.runthebank.service.ICadastrarPessoaService;
import br.com.runthebank.utils.CPF_CNPJ_Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CadastrarController {

    private TipoConta tipoConta;
    
    @Autowired
    private ClientePessoaFactory factory;
    
    @GetMapping("/live")
    public String onLive() {
    	return "Está ok!!!";
    }

    @PostMapping("/api/cadastrar")
    public String cadastrar(@RequestBody ClientePessoaDTO pessoaDTO) {
    	
    	String mensagem = "";
    	
    	Pessoa pessoa = converterDTO2Pessoa(pessoaDTO);
    	
    	
    	ICadastrarPessoaService cadastrarPessoaService = factory.getCadastrarPessoaService(this.tipoConta);
    	if(cadastrarPessoaService.cadastrarPessoa(pessoa) == true)
    	{
    		mensagem = "Cadastro realizado com sucesso!!!";
    	} else {
    		mensagem = "Cadastro do cliente deu erro!!!";
    	}
        
        return mensagem;
    }
    
    private Pessoa converterDTO2Pessoa(ClientePessoaDTO pessoaDTO) {
    	if(pessoaDTO.getCpf() != null && 
    			!pessoaDTO.getCpf().isEmpty() && 
    				(pessoaDTO.getCnpj() == null || 
    					pessoaDTO.getCnpj().isEmpty())) {
    		PessoaFisica pessoa = new PessoaFisica();
    		pessoa.setNome(pessoaDTO.getNome());
    		pessoa.setEndereco(pessoaDTO.getEndereco());
    		pessoa.setCpf(CPF_CNPJ_Utils.string2justLongNumbers(pessoaDTO.getCpf()));
    		
    		this.tipoConta = TipoConta.PF;
    		
    		return pessoa;
    	} else if(pessoaDTO.getCnpj() != null && 
	    			!pessoaDTO.getCnpj().isEmpty() && 
	    				(pessoaDTO.getCpf() == null ||
	    					pessoaDTO.getCpf().isEmpty())) {
    		PessoaJuridica pessoa = new PessoaJuridica();
    		pessoa.setNome(pessoaDTO.getNome());
    		pessoa.setEndereco(pessoaDTO.getEndereco());
    		pessoa.setCnpj(CPF_CNPJ_Utils.string2justLongNumbers(pessoaDTO.getCnpj()));
    		
    		this.tipoConta = TipoConta.PJ;
    		
    		return pessoa;
    	}else {
    		return null;
    	}
    }

	public ClientePessoaFactory getFactory() {
		return factory;
	}

	public void setFactory(ClientePessoaFactory factory) {
		this.factory = factory;
	}
    
}
