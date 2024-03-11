package com.icds.abertura_conta.model.dto.conta;

import com.icds.abertura_conta.model.dto.cliente.ConsultaClienteDTO;

public class ConsultaContaDTO {
	
	private Long id;
	private String agencia;
	private String conta;
	private ConsultaClienteDTO cliente;
	
	public ConsultaContaDTO() {
		
	}

	public ConsultaContaDTO(Long id, String agencia, String conta, ConsultaClienteDTO cliente) {
		super();
		this.id = id;
		this.agencia = agencia;
		this.conta = conta;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public ConsultaClienteDTO getCliente() {
		return cliente;
	}

	public void setCliente(ConsultaClienteDTO cliente) {
		this.cliente = cliente;
	}

}
