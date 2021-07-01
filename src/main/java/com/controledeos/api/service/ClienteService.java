package com.controledeos.api.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.controledeos.api.exception.ClienteNaoEncontradoException;
import com.controledeos.api.model.Cliente;
import com.controledeos.api.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente cadastrarCliente(Cliente cliente) {

		return clienteRepository.save(cliente);
	}
	
	public List<Cliente> listarTodosClientes(){
		
		return clienteRepository.findAll();
	}
	
	public Cliente encontraClientePorId(Long id) {
		
	    return clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
	}
	
	public Cliente atualizarCliente(Cliente cliente, Long id) {
		
		Cliente buscaId = clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
		if(buscaId != null) {
			
			BeanUtils.copyProperties(cliente, buscaId, "id");
			clienteRepository.save(buscaId);
		}
		return buscaId;
		
	}
	
	public void deletarClientePorId(Long id) {
		Cliente buscaId = clienteRepository.findById(id).orElseThrow(() -> new ClienteNaoEncontradoException(id));
		
		if(buscaId != null) {
		
		clienteRepository.deleteById(id);
		}
	}
	
	public List<Cliente> consultaDinamicaCliente(String nome, String telefone, String email) {

		return clienteRepository.find(nome, telefone, email);

	}

}
