package com.icds.abertura_conta.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.icds.abertura_conta.model.Cliente;
import com.icds.abertura_conta.repository.ClienteRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ClienteService {
	
	private final ClienteRepository repository;
	
	public ClienteService(ClienteRepository repository) {
		this.repository = repository;
	}
	
	public Cliente salvarCliente(Cliente cliente) {
		cliente = repository.save(cliente);
		return cliente;
	}

	public Page<Cliente> listarClientes(Pageable pageable) {
		return repository.findAll(pageable);
	}

	public Cliente buscarCliente(Long id) {
		Optional<Cliente> optional = repository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
	}

	public Cliente atualizarCliente(Cliente cliente, Long id) {
		Cliente clienteOriginal = this.buscarCliente(id);
		cliente.setId(clienteOriginal.getId());
		return repository.save(cliente);
	}

	public void excluirCliente(Long id) {
		Cliente cliente = this.buscarCliente(id);
		repository.delete(cliente);
	}

}
