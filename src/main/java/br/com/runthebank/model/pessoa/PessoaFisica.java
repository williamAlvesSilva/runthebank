package br.com.runthebank.model.pessoa;

public class PessoaFisica extends Pessoa{
    private long cpf;

    public long getCpf() {
		return cpf;
	}

    public void setCpf(long cpf) {
		this.cpf = cpf;
	}
}
