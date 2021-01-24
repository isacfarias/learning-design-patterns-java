package com.br.farias.interfaces;

public interface ModuloNotaFiscalEletronicaFactory {
	
	public NotaFiscalEletronica criarNfe() throws InstantiationException, IllegalAccessException, ClassNotFoundException;
	
	public Boleto criarBoleto() throws InstantiationException, IllegalAccessException, ClassNotFoundException;

}
