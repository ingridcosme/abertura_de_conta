package com.icds.abertura_conta.model.dto.endereco;

import com.icds.abertura_conta.model.Endereco;

public class EnderecoMapper {
	
	public static Endereco fromDTO(EnderecoDTO dto) {
		return new Endereco(
				dto.getCep(), 
				dto.getLogradouro(), 
				dto.getNumero(), 
				dto.getComplemento(), 
				dto.getBairro()
				);
	}

	public static EnderecoDTO fromEntity(Endereco endereco) {
		return new EnderecoDTO(
				endereco.getLogradouro(), 
				endereco.getNumero(), 
				endereco.getComplemento(), 
				endereco.getBairro(),
				endereco.getCep()
				);

	}

}
