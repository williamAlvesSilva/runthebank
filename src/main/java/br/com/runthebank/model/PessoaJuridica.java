package br.com.runthebank.model;

public class PessoaJuridica extends Pessoa{

    private long cnpj;

    public long getCnpj() {
		return cnpj;
	}

    public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
}
