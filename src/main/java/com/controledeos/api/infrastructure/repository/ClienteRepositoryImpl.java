package com.controledeos.api.infrastructure.repository;

import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.controledeos.api.model.Cliente;
import com.controledeos.api.repository.ClienteRepositoryQueries;

@Repository
public class ClienteRepositoryImpl implements ClienteRepositoryQueries {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cliente> find(String nome, String telefone, String email) {
		
	
		var jpql = new StringBuilder();
		jpql.append("from Cliente where 0 = 0 ");
		
		var parametros = new HashMap<String, Object>();

		if (StringUtils.hasLength(nome)) {

			jpql.append("and nome like :nome ");
			parametros.put("nome", "%" + nome + "%");
		}
		
		if (telefone != null) {

			jpql.append("and telefone = :telefone ");
			parametros.put("telefone", telefone);
		}

		if (email != null) {

			jpql.append("and email = :email ");
			parametros.put("email", email);
		}



		TypedQuery<Cliente> query = manager.createQuery(jpql.toString(), Cliente.class);

				parametros.forEach((chave, valor) -> query.setParameter(chave, valor));
				return query.getResultList();

	}

}
