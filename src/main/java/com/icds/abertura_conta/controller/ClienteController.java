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

import com.icds.abertura_conta.model.Cliente;
import com.icds.abertura_conta.model.dto.cliente.ClienteMapper;
import com.icds.abertura_conta.model.dto.cliente.ConsultaClienteDTO;
import com.icds.abertura_conta.model.dto.cliente.RegistroClienteDTO;
import com.icds.abertura_conta.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1/clientes")
public class ClienteController {

	private final ClienteService clienteService;

	public ClienteController(ClienteService clienteService) {
		this.clienteService = clienteService;
	}

	@PostMapping
	public ResponseEntity<ConsultaClienteDTO> salvarCliente(@RequestBody @Valid RegistroClienteDTO dto) {
		Cliente cliente = clienteService.salvarCliente(ClienteMapper.fromDTO(dto));
		return new ResponseEntity<>(ClienteMapper.fromEntity(cliente), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<Page<ConsultaClienteDTO>> listarClientes(@PageableDefault Pageable pageable) {
		return ResponseEntity.ok(clienteService.listarClientes(pageable).map(ClienteMapper::fromEntity));
	}

	@GetMapping("{id}")
	public ResponseEntity<Object> buscarCliente(@PathVariable Long id) {
		Cliente cliente = clienteService.buscarCliente(id);
		return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
	}

	@ResponseBody
	@PutMapping("{id}")
	public ResponseEntity<Object> alterarCliente(@RequestBody @Valid RegistroClienteDTO dto,
			@PathVariable Long id) {
		try {
			Cliente cliente = clienteService.atualizarCliente(ClienteMapper.fromDTO(dto), id);
			return ResponseEntity.ok(ClienteMapper.fromEntity(cliente));
		} catch (RuntimeException ex) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
		}
	}

	@ResponseBody
	@DeleteMapping("{id}")
	public ResponseEntity<Object> excluirCliente(@PathVariable Long id) {
		try {
			clienteService.excluirCliente(id);
			return ResponseEntity.status(HttpStatus.OK).body("Cliente removido com sucesso");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado");
		}
	}

}
