package com.controledeos.api.repository;

import java.util.List;

import com.controledeos.api.model.Cliente;
import com.controledeos.api.model.OrdemDeServico;
import com.controledeos.api.model.StatusOs;

public interface OrdemDeServicoRepositoryQueries {

	 List<OrdemDeServico> find(String tipo, String marca, String problema, StatusOs status, Cliente cliente );
}
