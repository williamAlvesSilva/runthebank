package br.com.runthebank.model.conta;

import java.util.List;

import br.com.runthebank.model.pessoa.Pessoa;

public class Conta {

	private long id;
    private long agencia;
    private int saldo;
    private SaldoState saldoState;
    private StatusConta status;
    private TipoConta tipoConta;
    private List<Pessoa> pessoaClienteList;
	public long getAgencia() {
		return agencia;
	}
	public void setAgencia(long agencia) {
		this.agencia = agencia;
	}
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public SaldoState isSaldoState() {
		return saldoState;
	}
	public void setSaldoState(SaldoState saldoState) {
		this.saldoState = saldoState;
	}
	public StatusConta getStatus() {
		return status;
	}
	public void setStatus(StatusConta status) {
		this.status = status;
	}
	public TipoConta getTipoConta() {
		return tipoConta;
	}
	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}
	public List<Pessoa> getPessoaCliente() {
		return pessoaClienteList;
	}
	public void setPessoaCliente(List<Pessoa> pessoaClienteList) {
		this.pessoaClienteList = pessoaClienteList;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
