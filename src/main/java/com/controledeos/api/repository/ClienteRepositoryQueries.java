package com.controledeos.api.repository;

import java.util.List;

import com.controledeos.api.model.Cliente;

public interface ClienteRepositoryQueries {

	 List<Cliente> find(String nome, String telefone, String email);
}
