package com.icds.abertura_conta.model.dto.endereco;

import jakarta.validation.constraints.NotBlank;

public class EnderecoDTO {
	
	@NotBlank
	private String cep;
	
	@NotBlank
	private String logradouro;
	
	private int numero;
	
	private String complemento;
	
	@NotBlank
	private String bairro;
	
	public EnderecoDTO() {
		
	}

	public EnderecoDTO(@NotBlank String logradouro, int numero, String complemento, @NotBlank String bairro, 
			@NotBlank String cep) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

}
