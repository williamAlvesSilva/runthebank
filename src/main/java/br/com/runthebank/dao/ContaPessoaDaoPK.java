package br.com.runthebank.dao;

import jakarta.persistence.IdClass;

@IdClass(ContaPessoaDaoPK.class)
public class ContaPessoaDaoPK {
	
	private String agenciaKeyID;
	private long idKeyID;

	public String getAgenciaKeyID() {
		return agenciaKeyID;
	}

	public void setAgenciaKeyID(String agenciaKeyID) {
		this.agenciaKeyID = agenciaKeyID;
	}

	public long getIdKeyID() {
		return idKeyID;
	}

	public void setIdKeyID(long idKeyID) {
		this.idKeyID = idKeyID;
	}

	
}
