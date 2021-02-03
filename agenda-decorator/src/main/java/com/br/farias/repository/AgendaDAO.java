package com.br.farias.repository;

import com.br.farias.model.Contato;

public interface AgendaDAO {
	
	public void inserir(Contato contato);
	
	public Contato buscar(Integer codigo);

}
