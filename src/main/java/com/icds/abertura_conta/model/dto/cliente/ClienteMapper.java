package com.icds.abertura_conta.model.dto.cliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.icds.abertura_conta.model.Cliente;
import com.icds.abertura_conta.model.dto.endereco.EnderecoMapper;

public class ClienteMapper {
	
	public static Cliente fromDTO(RegistroClienteDTO dto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dto.getDataNascimento(), formatter);
		
		return new Cliente(
				null,
				dto.getNome(), 
				dto.getCpf(), 
				dto.getEmail(), 
				dto.getCelular(), 
				date, 
				dto.getRendaMensal(), 
				EnderecoMapper.fromDTO(dto.getEndereco())
				);
	}
	
	public static Cliente fromDTO(ConsultaClienteDTO dto) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dto.getDataNascimento(), formatter);
		
		return new Cliente(
				dto.getId(), 
				dto.getNome(), 
				dto.getCpf(), 
				dto.getEmail(), 
				dto.getCelular(), 
				date, 
				dto.getRendaMensal(), 
				EnderecoMapper.fromDTO(dto.getEndereco())
				);
	}
	
	public static ConsultaClienteDTO fromEntity(Cliente cliente) {
		return new ConsultaClienteDTO(
				cliente.getId(), 
				cliente.getNome(), 
				cliente.getCpf(), 
				cliente.getEmail(), 
				cliente.getCelular(), 
				cliente.getDataNascimento().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), 
				cliente.getRendaMensal(), 
				EnderecoMapper.fromEntity(cliente.getEndereco())
				);
	}

}
