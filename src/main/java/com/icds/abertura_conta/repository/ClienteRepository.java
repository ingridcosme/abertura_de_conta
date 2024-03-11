package com.icds.abertura_conta.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.icds.abertura_conta.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	Page<Cliente> findAll(Pageable pageable);
	
}
