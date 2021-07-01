package com.controledeos.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.controledeos.api.model.Cliente;
import com.controledeos.api.model.OrdemDeServico;
import com.controledeos.api.model.StatusOs;
import com.controledeos.api.service.OrdemDeServicoService;

@RestController
@RequestMapping("/os")
public class OrdemDeServicoController {

	  @Autowired
	  private OrdemDeServicoService ordemDeServicoService;
	  
	  
	  @PostMapping
	  public ResponseEntity<?> cadastrarOrdemDeServico(@Valid @RequestBody OrdemDeServico ordemDeServico){
		  
		   OrdemDeServico os = ordemDeServicoService.cadastrarOrdemDeServico(ordemDeServico);
		   return ResponseEntity.status(HttpStatus.CREATED).body(os);
	  }
	  
	  
	  @PutMapping("/{id}")
	  public ResponseEntity<OrdemDeServico> atualizaOrdemDeServico
	     (@Valid @RequestBody OrdemDeServico ordemDeServico, @PathVariable Long id){
		  
		  OrdemDeServico atualiza = ordemDeServicoService.atualizarOrdemDeServico(ordemDeServico, id);
		  return ResponseEntity.status(HttpStatus.OK).body(atualiza);
	  }
	  
	  @GetMapping
	  public ResponseEntity<?> listaTodasOrdemDeServico(){
		  
		  List<OrdemDeServico> listaOrdemDeservico = ordemDeServicoService.listarTodasOrdemDeServico();
		  return ResponseEntity.status(HttpStatus.OK).body(listaOrdemDeservico);
	  }
	  
	  @GetMapping("/{id}")
	  public ResponseEntity<?> buscaOrdemDeServicoPorId(@PathVariable Long id){
		  
		  OrdemDeServico buscaPorId = ordemDeServicoService.buscarOrdemDeServicoPorId(id);
		  return ResponseEntity.status(HttpStatus.OK).body(buscaPorId);
	  }
	  
	  @DeleteMapping("/{id}")
	  public ResponseEntity<?> deletaOrdemDeServicoPorId(@PathVariable Long id){
		  
		  ordemDeServicoService.deltarOrdemDeServicoPorId(id);
		  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		  
	  }
	  
	  @GetMapping("/busca-dinamica")
	  public ResponseEntity<?> buscaDinamicaOrdemDeServico(String tipo, String marca, String problema, StatusOs status, Cliente cliente){
		  
		  List<OrdemDeServico> buscaDinamica = ordemDeServicoService.buscaDinamicaOrdemDeServico(tipo, marca, problema, status, cliente);
		  return ResponseEntity.status(HttpStatus.OK).body(buscaDinamica);
		  
	  }
}







