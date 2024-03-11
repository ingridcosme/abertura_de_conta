package com.icds.abertura_conta.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

import org.springframework.format.annotation.DateTimeFormat;

import com.icds.abertura_conta.validator.ValidaCPF;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "TB_CLIENTE")
public class Cliente implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	private String nome;
	
	@ValidaCPF
	@Column(unique = true)
	private String cpf;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Pattern(regexp = "\\d+", message = "O DDD + número de celular deve conter apenas números")
	private String celular;
	
	@NotNull
	@Past
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	private BigDecimal rendaMensal;
	
	@Embedded
	@NotNull
	private Endereco endereco;
	
	public Cliente() {
		
	}

	public Cliente(Long id, String nome, String cpf, String email, String celular, LocalDate dataNascimento,
			BigDecimal rendaMensal, Endereco endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.celular = celular;
		this.dataNascimento = dataNascimento;
		this.rendaMensal = rendaMensal;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public BigDecimal getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(BigDecimal rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", celular=" + celular
				+ ", dataNascimento=" + dataNascimento + ", rendaMensal=" + rendaMensal + ", endereco=" + endereco
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(celular, cpf, dataNascimento, email, endereco, id, nome, rendaMensal);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(celular, other.celular) && cpf == other.cpf
				&& Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && id == other.id && Objects.equals(nome, other.nome)
				&& Objects.equals(rendaMensal, other.rendaMensal);
	}

}
