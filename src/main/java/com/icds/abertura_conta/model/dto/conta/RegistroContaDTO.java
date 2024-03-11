package com.icds.abertura_conta.model.dto.conta;

import com.icds.abertura_conta.model.dto.cliente.ConsultaClienteDTO;

import jakarta.validation.constraints.NotBlank;

public class RegistroContaDTO {
	
	@NotBlank
	private String senha;
	private ConsultaClienteDTO cliente;
	
	public RegistroContaDTO() {
		
	}

	public RegistroContaDTO(@NotBlank String senha, ConsultaClienteDTO cliente) {
		this.senha = senha;
		this.cliente = cliente;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public ConsultaClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ConsultaClienteDTO cliente) {
		this.cliente = cliente;
	}

}
