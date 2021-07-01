package com.controledeos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.controledeos.api.model.OrdemDeServico;

public interface OrdemDeServicoRepository extends JpaRepository<OrdemDeServico, Long>, OrdemDeServicoRepositoryQueries {

}
