package com.icds.abertura_conta.model;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "TB_CONTA")
public class Conta implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String agencia;
	public static final String AGENCIA = "1704";
	
	@Column(unique = true)
	private String conta;
	
	@NotNull
	private String senha;
	
	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	public Conta() {
		
	}

	public Conta(Long id, String agencia, String conta, String senha, Cliente cliente) {
		this.id = id;
		this.agencia = AGENCIA;
		this.conta = conta;
		this.senha = senha;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia() {
		this.agencia = AGENCIA;
	}

	@Override
	public String toString() {
		return "Conta [id=" + id + ", agencia=" + agencia + ", conta=" + conta + ", senha=" + senha + ", cliente="
				+ cliente + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(agencia, cliente, conta, id, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		return Objects.equals(agencia, other.agencia) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(conta, other.conta) && id == other.id && Objects.equals(senha, other.senha);
	}
	
}
