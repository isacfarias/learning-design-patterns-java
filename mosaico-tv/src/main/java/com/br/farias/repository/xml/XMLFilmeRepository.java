package com.br.farias.repository.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import com.br.farias.model.Filme;
import com.br.farias.repository.FilmeRepository;
import com.thoughtworks.xstream.XStream;

public class XMLFilmeRepository implements FilmeRepository {

	@Override
	public void salvar(Filme filme) {
		XStream xStream = new XStream();
		xStream.alias("filme", Filme.class);
		OutputStream out = null;
		try {
			out = new FileOutputStream(filme.getDescricao().replaceAll(" ",  "_")+".xml");
			xStream.toXML(filme, out);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Erro ao salvar arquivo:"+e);
		}
	}

}
