package com.icds.abertura_conta.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CPFValidator implements ConstraintValidator<ValidaCPF, String> {

	@Override
	public boolean isValid(String cpf, ConstraintValidatorContext context) {
		if (cpf == null || cpf.length() != 11 || !cpf.matches("\\d+") || 
				cpf.matches("(\\d)\\1{10}")) {
            return false;
        }
		int[] digitos = new int[11];
        for (int i = 0; i < cpf.length(); i++) {
            int numero = Character.getNumericValue(cpf.charAt(i));
            digitos[i] = numero;
        }
		int resto, indiceDV;
		try {
			indiceDV = 9;
			resto = calcularResto(digitos, 10, indiceDV);
			
			if (resto != digitos[indiceDV]) {
				return false;
			}
			indiceDV = 10;
			resto = calcularResto(digitos, 11, indiceDV);
			
			if (resto != digitos[indiceDV]) {
				return false;
			}
		} catch(Exception e) {
			return false;
		}
		return true;
	}

	private int calcularResto(int[] digitos, int peso, int indiceDV) {
		int soma = 0;
		int resto;
		int numero;
		for (int i = 0; i < indiceDV; i++) {
			numero = digitos[i];
			soma += (numero * peso);
			peso--;
		}
		resto = (soma*10)%11;
		if (resto == 10) {
			resto = 0;
		}
		return resto;
	}

}