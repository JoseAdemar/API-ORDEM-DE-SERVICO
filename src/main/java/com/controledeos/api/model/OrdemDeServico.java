package com.controledeos.api.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class OrdemDeServico {

	 @EqualsAndHashCode.Include
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Id
	 private Long id;
	 
	 
	 @NotNull
	 private String tipo;
	 
	 @NotNull
	 private String marca;
	 
	 @NotNull
	 private String problema;
	 
	 
	 @ManyToOne
	 @JoinColumn(name = "cliente_id")
	 private Cliente cliente;
	 
	 
	 @Enumerated(EnumType.STRING)
	 private StatusOs status;
	 
	 @CreationTimestamp
	 private LocalDate dataInicio;
	 
	 private LocalDate dataEntrega;
	 
	 
	 private String descricao;
}
