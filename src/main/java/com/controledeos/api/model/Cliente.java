package com.controledeos.api.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente {

	 @EqualsAndHashCode.Include
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 @Id
	 private Long id;
	 
	 @NotNull
	 private String nome;
	 
	 @Embedded
	 private Endereco endereco;
	 
	 @NotNull
	 private String telefone;
	 
	 @NotNull
	 @Email
	 private String email;
}
