package com.icds.abertura_conta.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.icds.abertura_conta.model.Conta;

public interface ContaRepository extends JpaRepository<Conta, Long> {
	
	Page<Conta> findAll(Pageable pageable);
	
	Optional<Conta> findByCliente_Id(@Param("cliente") Long clienteId);

}
