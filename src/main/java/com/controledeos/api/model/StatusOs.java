package com.controledeos.api.model;

public enum StatusOs {

	INICIADO("Iniciado"), 
	CANCELADO("Cancelado"), 
	PENDENTE("Pendente"), 
	FINALIZADO("Finalizado");

	private String descricao;

	StatusOs(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return this.descricao;
	}

}
