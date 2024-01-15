package br.com.runthebank.model;

public class Conta {

    private long id;
    private long agencia;
    private int saldo;
    private boolean estaNegativoSaldo;
    private StatusConta status;
    private TipoConta tipoConta;
    private Pessoa pessoaCliente;
}
