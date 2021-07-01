package com.controledeos.api.infrastructure.repository;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.controledeos.api.model.Cliente;
import com.controledeos.api.model.OrdemDeServico;
import com.controledeos.api.model.StatusOs;
import com.controledeos.api.repository.OrdemDeServicoRepositoryQueries;

@Repository
public class OrdemDeServicoRepositoryImpl implements OrdemDeServicoRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<OrdemDeServico> find(String tipo, String marca, String problema, StatusOs status, Cliente cliente) {
		
		var jpql = new StringBuilder();
		jpql.append("from OrdemDeServico where 0 = 0 ");
		
		var parametros = new HashMap<String, Object>();

		if (StringUtils.hasLength(tipo)) {

			jpql.append("and tipo like :tipo ");
			parametros.put("tipo", "%" + tipo + "%");
		}
		
		if (marca != null) {

			jpql.append("and marca like :marca ");
			parametros.put("marca", "%" + marca + "%");
		}

		if (problema != null) {

			jpql.append("and problema like :problema ");
			parametros.put("problema", "%" + problema + "%");
		}
		
		if (status != null) {

			jpql.append("and status = :status ");
			parametros.put("status", status);
		}
		
		if (cliente.getEmail() != null) {

			jpql.append("and cliente.email = :clienteEmail ");
			parametros.put("clienteEmail", cliente.getEmail());
		}



		TypedQuery<OrdemDeServico> query = manager.createQuery(jpql.toString(), OrdemDeServico.class);

				parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
				return query.getResultList();

	}

}