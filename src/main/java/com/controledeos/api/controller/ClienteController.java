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
import com.controledeos.api.service.ClienteService;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	 @PostMapping
	 public ResponseEntity<?> cadastraCliente(@Valid @RequestBody Cliente cliente){
		 
		     Cliente cadastro = clienteService.cadastrarCliente(cliente);
		     return ResponseEntity.status(HttpStatus.CREATED).body(cadastro);
	 }
	 
	 @GetMapping
	 public ResponseEntity<?> listaTodosClientes(){
		 
		   List<Cliente> listaClientes = clienteService.listarTodosClientes();
		   return ResponseEntity.status(HttpStatus.OK).body(listaClientes);
	 }
	 
	 @PutMapping("/{id}")
	 public ResponseEntity<Cliente> atualizaCliente
	 (@Valid @RequestBody Cliente cliente, @PathVariable Long id){
		 
		 Cliente atualiza = clienteService.atualizarCliente(cliente, id);
		 
		 return ResponseEntity.status(HttpStatus.OK).body(atualiza);
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<?> buscaClientePorId(@PathVariable Long id){
		 
		 Cliente buscaPorId = clienteService.encontraClientePorId(id);
		 return ResponseEntity.status(HttpStatus.OK).body(buscaPorId);
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Cliente> deletaClientePorId(@PathVariable Long id){
		 
		  clienteService.deletarClientePorId(id);
		  return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	 }
	 
	 @GetMapping("/consulta-dinamica")
	 public ResponseEntity<?> consultaDinamicaPaciente(String nome, String telefone, String email){
		 
		 List<Cliente> buscaDinamica = clienteService.consultaDinamicaCliente(nome, telefone, email);
		 return ResponseEntity.status(HttpStatus.OK).body(buscaDinamica);
	 }
	 
	 
}
