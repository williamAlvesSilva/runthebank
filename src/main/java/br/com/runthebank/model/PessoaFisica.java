package br.com.runthebank.model;

public class PessoaFisica extends Pessoa{
    private long cpf;

    public long getCpf() {
		return cpf;
	}

    public void setCpf(long cpf) {
		this.cpf = cpf;
	}
}
