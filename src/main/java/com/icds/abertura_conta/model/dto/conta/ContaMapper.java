package com.icds.abertura_conta.model.dto.conta;

import com.icds.abertura_conta.model.Conta;
import com.icds.abertura_conta.model.dto.cliente.ClienteMapper;

public class ContaMapper {
	
	public static Conta fromDTO(RegistroContaDTO dto) {
		return new Conta(
				null, 
				null, 
				null, 
				dto.getSenha(), 
				ClienteMapper.fromDTO(dto.getCliente())
				);
	}

	public static ConsultaContaDTO fromEntity(Conta conta) {
		return new ConsultaContaDTO(
				conta.getId(), 
				conta.getAgencia(), 
				conta.getConta(), 
				ClienteMapper.fromEntity(conta.getCliente())
				);
	}

}
