package br.com.runthebank.model.DTO;

public class TransferenciaDTO {
	private String agenciaRemetente;
	private String valorTransferencia;
	
	private String agenciaBeneficio;

	public String getAgenciaRemetente() {
		return agenciaRemetente;
	}

	public void setAgenciaRemetente(String agenciaRemetente) {
		this.agenciaRemetente = agenciaRemetente;
	}

	public String getValorTransferencia() {
		return valorTransferencia;
	}

	public void setValorTransferencia(String valorTransferencia) {
		this.valorTransferencia = valorTransferencia;
	}

	public String getAgenciaBeneficio() {
		return agenciaBeneficio;
	}

	public void setAgenciaBeneficio(String agenciaBeneficio) {
		this.agenciaBeneficio = agenciaBeneficio;
	}
}
