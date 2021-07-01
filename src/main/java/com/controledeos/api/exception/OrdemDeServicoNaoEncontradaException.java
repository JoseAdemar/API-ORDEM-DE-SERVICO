package com.controledeos.api.exception;

public class OrdemDeServicoNaoEncontradaException extends EntidadeNaoEncontradaException {

	private static final long serialVersionUID = 1L;

	public OrdemDeServicoNaoEncontradaException(String mensagem) {
		super(mensagem);

	}
	
	public OrdemDeServicoNaoEncontradaException(Long ordemDeServicoId) {
		this(String.format("Não existe um cadastro de ordem de serviço com código %d", ordemDeServicoId));
	}

}
