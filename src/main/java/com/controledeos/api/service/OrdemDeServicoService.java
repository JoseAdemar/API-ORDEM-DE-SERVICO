package com.controledeos.api.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeos.api.exception.ClienteNaoEncontradoException;
import com.controledeos.api.exception.OrdemDeServicoNaoEncontradaException;
import com.controledeos.api.model.Cliente;
import com.controledeos.api.model.OrdemDeServico;
import com.controledeos.api.model.StatusOs;
import com.controledeos.api.repository.OrdemDeServicoRepository;

@Service
public class OrdemDeServicoService {

	@Autowired
	private OrdemDeServicoRepository ordemDeServicoRepository;

	public OrdemDeServico cadastrarOrdemDeServico(OrdemDeServico ordemDeServico) {

		ordemDeServico.setStatus(StatusOs.INICIADO);
		return ordemDeServicoRepository.save(ordemDeServico);

	}

	public OrdemDeServico atualizarOrdemDeServico(OrdemDeServico ordemDeServico, Long id) {

		OrdemDeServico buscaOrdemDeServico = ordemDeServicoRepository.findById(id)
				.orElseThrow(() -> new ClienteNaoEncontradoException(id));

		if (buscaOrdemDeServico != null) {

			buscaOrdemDeServico.getStatus();

			if (buscaOrdemDeServico.getStatus() != StatusOs.FINALIZADO
					|| buscaOrdemDeServico.getStatus() == StatusOs.CANCELADO
					|| buscaOrdemDeServico.getStatus() == StatusOs.PENDENTE
					|| buscaOrdemDeServico.getStatus() == StatusOs.INICIADO) {

				BeanUtils.copyProperties(ordemDeServico, buscaOrdemDeServico, "id", "dataInicio");
				
				if(buscaOrdemDeServico.getStatus() == StatusOs.FINALIZADO) {
					
					buscaOrdemDeServico.setDataEntrega(LocalDate.now());
				}
				return ordemDeServicoRepository.save(buscaOrdemDeServico);
			}

		}
		return buscaOrdemDeServico;

	}

	public List<OrdemDeServico> listarTodasOrdemDeServico() {

		return ordemDeServicoRepository.findAll();
	}

	public OrdemDeServico buscarOrdemDeServicoPorId(Long id) {

		return ordemDeServicoRepository.findById(id).orElseThrow(() -> new OrdemDeServicoNaoEncontradaException(id));
	}

	public void deltarOrdemDeServicoPorId(Long id) {

		ordemDeServicoRepository.deleteById(id);
	}

	public List<OrdemDeServico> buscaDinamicaOrdemDeServico(String tipo, String marca, String problema, StatusOs status,
			Cliente cliente) {

		return ordemDeServicoRepository.find(tipo, marca, problema, status, cliente);

	}
}
