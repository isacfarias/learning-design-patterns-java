package com.br.farias.bean.impl;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import javax.inject.Inject;

import com.br.farias.bean.FilmeService;
import com.br.farias.enums.Tipo;
import com.br.farias.model.Filme;
import com.br.farias.repository.xml.XMLFilmeRepository;

public class FilmeServiceImpl implements FilmeService {

	@Inject
	private XMLFilmeRepository filmeRepository;
	
	@Override
	public void salvar(Filme filme) {
		
		filme.setTipo( isNewFilme(filme.getData()) ? Tipo.NOVO: Tipo.ANTIGO);
		
		filmeRepository.salvar(filme);
	}

	private boolean isNewFilme(Date date) {
		boolean ehNovo = false;
		LocalDate dataManipulacao = LocalDate.now().minusMonths(3);
		
		LocalDate dataFilme  = date.toInstant()
				                   .atZone(ZoneId.systemDefault())
				                   .toLocalDate();
		
		if (dataFilme.isAfter(dataManipulacao)) ehNovo = true; 
		
		return ehNovo;
	}

}
