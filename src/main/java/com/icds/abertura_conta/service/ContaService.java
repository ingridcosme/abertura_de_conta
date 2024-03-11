package com.icds.abertura_conta.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.icds.abertura_conta.model.Conta;
import com.icds.abertura_conta.repository.ContaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ContaService {
	
	private final ContaRepository contaRepository;
	
	public ContaService(ContaRepository contaRepository) {
		this.contaRepository = contaRepository;
	}
	
	public Conta salvarConta(Conta conta) {
		boolean contaExiste = true;
		while(contaExiste) {
			try {
				conta.setConta(gerarContaComDV());
				conta = contaRepository.save(conta);
				contaExiste = false;
			} catch(RuntimeException e) {
				contaExiste = true;
			}
		}
		return conta;
	}

	public Page<Conta> listarContas(Pageable pageable) {
		return contaRepository.findAll(pageable);
	}

	public Conta buscarConta(Long id) {		
		Optional<Conta> optional = contaRepository.findById(id);
		return optional.orElseThrow(() -> new EntityNotFoundException("Conta não encontrada"));
	}
	
	public Conta buscarContaDeUmCliente(Long clienteId) {
		Optional<Conta> optionalConta = contaRepository.findByCliente_Id(clienteId);
		return optionalConta.orElseThrow(() -> new EntityNotFoundException("Cliente não encontrado"));
	}
		
	public Conta alterarConta(Conta conta, Long id) {
		Conta contaOriginal = this.buscarConta(id);
		conta.setId(contaOriginal.getId());
		return contaRepository.save(conta);
	}
	
	public void excluirConta(Long id) {
		Conta conta = this.buscarConta(id);
		contaRepository.delete(conta);
	}
		
	private String gerarContaComDV() {
		String numeroConta = gerarConta();
		String numeroDV = calcularDigitoVerificador(numeroConta);
		
		return numeroConta + "-" + numeroDV;
	}
    
    private String gerarConta() {
        Random random = new Random();
        int numeroConta = random.nextInt(90000) + 10000;
        
        return String.valueOf(numeroConta);
    }
	
	private String calcularDigitoVerificador(String numero) {
        int soma = 0;
        int multiplicador = 2;
        
        for (int i = 0; i < numero.length(); i++) {
            int digito = Character.getNumericValue(numero.charAt(i));
            
            if (multiplicador == 1) {
                soma += digito;
                multiplicador = 2;
            } else {
                int resultadoParcial = digito * 2;
                soma += resultadoParcial > 9 ? resultadoParcial - 9 : resultadoParcial;
                multiplicador = 1;
            }
        }
        
        int resto = soma % 10;
        int digitoVerificador = resto == 0 ? 0 : 10 - resto;
        
        return String.valueOf(digitoVerificador);
    }
	
}
