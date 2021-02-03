package com.br.farias.repository.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

import com.br.farias.model.Contato;
import com.br.farias.repository.AgendaDAO;
import com.thoughtworks.xstream.XStream;

public class XMLAgendaDAO implements AgendaDAO {

	@Override
	public void inserir(Contato contato) {
		XStream xStream = new XStream();
		xStream.alias("contato", Contato.class);
		OutputStream out = null;
		try {
			out = new FileOutputStream("contatos.xml");
			xStream.toXML(contato, out);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Erro ao salvar arquivo:"+e);
		}
	}

	@Override
	public Contato buscar(Integer codigo) {
		XStream xstream = new XStream();
		xstream.alias("contato", Contato.class);
		Contato temp = null;
		try {
			temp =  (Contato) xstream.fromXML(new FileInputStream(new File("contatos.xml")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
//		Contato contato = temp.stream()
//				              .filter( c -> c.getCodigo().equals(codigo))
//				              .collect(Collectors.toList()).get(0);
		
		return temp;
	}

}
