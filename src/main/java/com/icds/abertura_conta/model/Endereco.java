package com.icds.abertura_conta.model;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Embeddable
public class Endereco {
	
	@NotNull
	@Pattern(regexp = "\\d+", message = "O CEP deve conter apenas números")
	private String cep;
	
	@NotNull
	private String logradouro;
	
	@NotNull
	private int numero;
	
	@NotNull
	private String complemento;
	
	@NotNull
	private String bairro;
	
	public Endereco() {
		
	}

	public Endereco(String cep, String logradouro, int numero, String complemento, String bairro) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	@Override
	public String toString() {
		return "Endereco [cep=" + cep + ", logradouro=" + logradouro + ", numero=" + numero + ", complemento="
				+ complemento + ", bairro=" + bairro + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, complemento, logradouro, numero);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Endereco other = (Endereco) obj;
		return Objects.equals(bairro, other.bairro) && cep == other.cep
				&& Objects.equals(complemento, other.complemento) && Objects.equals(logradouro, other.logradouro)
				&& numero == other.numero;
	}

}
