package com.icds.abertura_conta.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.icds.abertura_conta.model.Conta;
import com.icds.abertura_conta.model.dto.conta.ConsultaContaDTO;
import com.icds.abertura_conta.model.dto.conta.ContaMapper;
import com.icds.abertura_conta.model.dto.conta.RegistroContaDTO;
import com.icds.abertura_conta.service.ContaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/v1/contas")
public class ContaController {
	
	private final ContaService contaService;

	public ContaController(ContaService contaService) {
		this.contaService = contaService;
	}
	
	@PostMapping
	public ResponseEntity<ConsultaContaDTO> salvarConta(@RequestBody @Valid RegistroContaDTO dto) {
		Conta conta = contaService.salvarConta(ContaMapper.fromDTO(dto));
		return new ResponseEntity<>(ContaMapper.fromEntity(conta), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<Page<ConsultaContaDTO>> listarContas(@PageableDefault Pageable pageable) {
		return ResponseEntity
				.ok(contaService.listarContas(pageable).map(ContaMapper::fromEntity));
	}
	
	@GetMapping("{clienteId}")
	public ResponseEntity<ConsultaContaDTO> buscarContaDeUmCliente(@PathVariable Long clienteId) {
		Conta conta = contaService.buscarContaDeUmCliente(clienteId);
		return ResponseEntity.ok(ContaMapper.fromEntity(conta));
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> buscarConta(@PathVariable Long id) {
		Conta conta = contaService.buscarConta(id);
		return ResponseEntity.ok(ContaMapper.fromEntity(conta));
	}

	@ResponseBody
	@PutMapping("{id}")
	public ResponseEntity<Object> alterarConta(@RequestBody @Valid RegistroContaDTO dto,
			@PathVariable Long id) {
		try {
			Conta conta = contaService.alterarConta(ContaMapper.fromDTO(dto), id);
			return ResponseEntity.ok(ContaMapper.fromEntity(conta));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada");
		}
	}

	@ResponseBody
	@DeleteMapping("{id}")
	public ResponseEntity<Object> excluirConta(@PathVariable Long id) {
		try {
			contaService.excluirConta(id);
			return ResponseEntity.status(HttpStatus.OK).body("Conta removida com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Conta não encontrada");
		}
	}

}
