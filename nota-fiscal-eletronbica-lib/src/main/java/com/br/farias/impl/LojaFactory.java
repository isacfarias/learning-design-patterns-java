package com.br.farias.impl;

import java.io.IOException;
import java.util.Properties;

import com.br.farias.interfaces.Boleto;
import com.br.farias.interfaces.ModuloNotaFiscalEletronicaFactory;
import com.br.farias.interfaces.NotaFiscalEletronica;

public class LojaFactory implements ModuloNotaFiscalEletronicaFactory {

	private Properties prop;
	public LojaFactory() throws IOException {
		prop = new Properties();
		prop.load(this.getClass().getResourceAsStream("/config.properties"));
	}
	
	
	public NotaFiscalEletronica criarNfe() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String classeNFe = this.prop.getProperty("nfe");
		return (NotaFiscalEletronica) Class.forName(classeNFe).newInstance();
	}

	public Boleto criarBoleto() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		String boleto = this.prop.getProperty("boleto");
		return (Boleto) Class.forName(boleto).newInstance();
	}

	
	 
}
