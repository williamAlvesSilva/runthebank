package br.com.runthebank.model.transferencia;

public class Transferencia {
	private String agenciaRemetente;
	private int valorTransferencia;
	
	private String agenciaBeneficio;

	public String getAgenciaRemetente() {
		return agenciaRemetente;
	}

	public void setAgenciaRemetente(String agenciaRemetente) {
		this.agenciaRemetente = agenciaRemetente;
	}

	public int getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(int valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public String getAgenciaBeneficio() {
		return agenciaBeneficio;
	}

	public void setAgenciaBeneficio(String agenciaBeneficio) {
		this.agenciaBeneficio = agenciaBeneficio;
	}
}
