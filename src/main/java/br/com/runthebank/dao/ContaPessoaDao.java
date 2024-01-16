package br.com.runthebank.dao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@IdClass(ContaPessoaDaoPK.class)
@Table(name = "conta")
public class ContaPessoaDao {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long idKeyID;
	
	@Id
	@Column(name = "AGENCIA_KEYID", unique = true)
	private String agenciaKeyID;
	
	@Column(name = "SALDO")
	private int saldo;
	
	@Column(name = "SALDO_N_O_P")
	private String saldoState;
	
	@Column(name = "STATUS")
	private long status;
	
	@Column(name = "IS_CLIENT_PF")
	private boolean isClientPF;
	
	@Column(name = "OWNER_CLIENT_ID")
	private long ownerClientId;

	public long getId() {
		return idKeyID;
	}

	public void setId(long idKeyID) {
		this.idKeyID = idKeyID;
	}

	public String getAgenciaKeyID() {
		return agenciaKeyID;
	}

	public void setAgenciaKeyID(String agenciaKeyID) {
		this.agenciaKeyID = agenciaKeyID;
	}

	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public String isSaldo_N_O_P() {
		return saldoState;
	}

	public void setSaldoIsNegative_Zero_Positive(String saldoState) {
		this.saldoState = saldoState;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public boolean isClientPF() {
		return isClientPF;
	}

	public void setClientPF(boolean isClientPF) {
		this.isClientPF = isClientPF;
	}

	public long getOwnerClientId() {
		return ownerClientId;
	}

	public void setOwnerClientId(long ownerClientId) {
		this.ownerClientId = ownerClientId;
	}
}
