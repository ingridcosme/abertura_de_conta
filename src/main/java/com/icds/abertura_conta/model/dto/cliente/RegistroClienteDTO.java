package com.icds.abertura_conta.model.dto.cliente;

import java.math.BigDecimal;

import com.icds.abertura_conta.model.dto.endereco.EnderecoDTO;

import jakarta.validation.constraints.NotBlank;

public class RegistroClienteDTO {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String cpf;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String celular;
	
	@NotBlank
	private String dataNascimento;
	
	private BigDecimal rendaMensal;
	
	private EnderecoDTO endereco;

	public RegistroClienteDTO() {
		
	}

	public RegistroClienteDTO(@NotBlank String nome, @NotBlank String cpf, @NotBlank String email,
			@NotBlank String celular, @NotBlank String dataNascimento, @NotBlank BigDecimal rendaMensal,
			@NotBlank EnderecoDTO endereco) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.celular = celular;
		this.dataNascimento = dataNascimento;
		this.rendaMensal = rendaMensal;
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(BigDecimal rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}

}
