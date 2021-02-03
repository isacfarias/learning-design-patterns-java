package com.br.farias.repository.impl;

import java.util.HashMap;
import java.util.Map;

import com.br.farias.model.Contato;
import com.br.farias.repository.AgendaDAO;

public class CacheAgendaDAO implements AgendaDAO {
	
	private AgendaDAO dao;
	private Map<Integer, Contato> cache;
	
	public CacheAgendaDAO(AgendaDAO dao) {
		this.dao = dao;
		this.cache = new HashMap<>();
	}

	@Override
	public void inserir(Contato contato) {
		dao.inserir(contato);
	}

	@Override
	public Contato buscar(Integer codigo) {
		
		Contato contato = null;
		if (cache.containsKey(codigo)) {
			contato = cache.get(codigo);
		} else {
			contato = dao.buscar(codigo);
			this.cache.put(contato.getCodigo(), contato);
		}
		
		return contato;
	}
	
	public Map<Integer, Contato> contatos() {
		return cache;
	}

}
