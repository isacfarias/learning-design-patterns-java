package com.br.maladireta.xml;

import java.net.URL;
import java.util.List;

import com.br.maladireta.model.Contato;
import com.br.maladireta.repository.Contatos;
import com.thoughtworks.xstream.XStream;

public class ContatosXML implements Contatos{
	
	
	private String nomeArquivo;

	public ContatosXML(String nomeArquivo) {
		super();
		this.nomeArquivo = nomeArquivo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Contato> todos() {
		XStream xstream = new XStream();
	    xstream.alias("contatos", List.class);
	    xstream.alias("contato", Contato.class);
	    
	    URL arquivo = this.getClass().getResource("/" + nomeArquivo);
	    System.out.println("arquivo importado:"+arquivo);
	    return (List<Contato>) xstream.fromXML(arquivo);
	}
}
