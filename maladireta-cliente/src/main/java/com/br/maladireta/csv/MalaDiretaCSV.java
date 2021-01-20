package com.br.maladireta.csv;

import com.br.maladireta.MalaDireta;
import com.br.maladireta.repository.Contatos;

public class MalaDiretaCSV extends MalaDireta {

	private String nomeArquivo;
	
	public MalaDiretaCSV(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}

	@Override
	protected Contatos criarContatos() {
		return (Contatos) new ContatosCSV(this.nomeArquivo);
	}

}
