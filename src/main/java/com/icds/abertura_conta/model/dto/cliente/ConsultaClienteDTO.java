package com.icds.abertura_conta.model.dto.cliente;

import java.math.BigDecimal;

import com.icds.abertura_conta.model.dto.endereco.EnderecoDTO;

public class ConsultaClienteDTO {
	
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String celular;
	private String dataNascimento;
	private BigDecimal rendaMensal;
	private EnderecoDTO endereco;
	
	public ConsultaClienteDTO() {

	}

	public ConsultaClienteDTO(Long id, String nome, String cpf, String email, String celular, String dataNascimento,
			BigDecimal rendaMensal, EnderecoDTO endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.celular = celular;
		this.dataNascimento = dataNascimento;
		this.rendaMensal = rendaMensal;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
