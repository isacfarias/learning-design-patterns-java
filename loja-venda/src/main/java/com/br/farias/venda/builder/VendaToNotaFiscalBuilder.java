package com.br.farias.venda.builder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

import com.br.farias.model.Cliente;
import com.br.farias.model.NotaFiscal;
import com.br.farias.model.Produto;

public class VendaToNotaFiscalBuilder {
	
	private NotaFiscal notaFiscal;
	
	public VendaToNotaFiscalBuilder() {
		this.notaFiscal = new NotaFiscal();
	}
	
	public VendaToNotaFiscalBuilder cliente(String nome) {
		this.notaFiscal.setCleinte(new Cliente(nome));
		return this;
	}
	
	public VendaToNotaFiscalBuilder addItem(String item, Integer quantidade, String valorUnitario) {
		if (this.notaFiscal.getProdutos() == null) 
			this.notaFiscal.setProdutos(new ArrayList<Produto>());
		this.notaFiscal.getProdutos().add(new Produto(item, quantidade, new BigDecimal(valorUnitario)));
		return this;
	}
	
	public NotaFiscal builder() {
		return notaFiscal;
	}

}
