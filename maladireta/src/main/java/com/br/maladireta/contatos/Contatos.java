package com.br.maladireta.contatos;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.br.maladireta.model.Contato;
import com.thoughtworks.xstream.XStream;

import au.com.bytecode.opencsv.CSVReader;

public class Contatos {
	
	public List<Contato> recuperarContatosCSV(String nomeArquivo) {
		List<Contato> contatos = new ArrayList<>();
		CSVReader csvReader = null;
		
		try {
			URI uri = this.getClass().getResource("/" + nomeArquivo).toURI();
			File arquivoCsv = new File(uri);
			FileReader fileReader = new FileReader(arquivoCsv);
			csvReader = new CSVReader(fileReader);
		    String [] nextLine;
		    
		    while ((nextLine = csvReader.readNext()) != null) {
		    	
		    	String nome = nextLine[0].trim();
		    	String email = nextLine[1].trim();
		    	
		    	contatos.add(new Contato());
		    }
		    
		} catch (Exception e) {
			throw new RuntimeException("Erro lendo arquivo csv", e);
		} finally {
			try {
	            csvReader.close();
            } catch (IOException e) { }
		}
		
		return contatos;
    }
	
	@SuppressWarnings("unchecked")
    public List<Contato> recuperarContatosXML(String nomeArquivo) {
		XStream xstream = new XStream();
	    xstream.alias("contatos", List.class);
	    xstream.alias("contato", Contato.class);
	    
	    URL arquivo = this.getClass().getResource("/" + nomeArquivo);
	    System.out.println("arquivo importado:"+arquivo);
	    return (List<Contato>) xstream.fromXML(arquivo);
	}
}