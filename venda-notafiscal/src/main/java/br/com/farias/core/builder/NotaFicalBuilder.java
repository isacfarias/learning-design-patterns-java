package br.com.farias.core.builder;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import br.com.farias.core.abstracts.NotaFiscalCalcula;
import br.com.farias.core.abstracts.NotaFiscalPessoaFisicaCreator;
import br.com.farias.core.abstracts.NotaFiscalPessoaJuridicaCreator;
import br.com.farias.core.enums.PessoaTipo;
import br.com.farias.model.Cliente;
import br.com.farias.model.NotaFiscal;
import br.com.farias.model.Produto;

public class NotaFicalBuilder {
	
	
	private NotaFiscal notaFiscal;
	private NotaFiscalCalcula calcula;
	
	public NotaFicalBuilder() {
		this.notaFiscal = new NotaFiscal();
		this.notaFiscal.setNumero(UUID.randomUUID()+"");
	}
	
	public NotaFicalBuilder cliente(String nome, PessoaTipo tipo) {
		this.notaFiscal.setCliente(new Cliente(nome, tipo));
		return this;
	}
	
	public NotaFicalBuilder addItem(String nome, Integer quantidade, Object valor ) throws Exception {
		if (this.notaFiscal.getProdutos() == null) 
			this.notaFiscal.setProdutos(new ArrayList<Produto>());
		
		BigDecimal vlr = null;
		if ( valor instanceof String ) {
			vlr = new BigDecimal((String) valor);
		} else if ( valor instanceof Double ) {
			vlr = new BigDecimal((Double) valor);
		} else {
			throw new Exception("Formato de valor não aceito");
		}
		
		this.notaFiscal.setProdutos(Arrays.asList(new Produto(nome, quantidade, vlr)));
		return this;
	}
	
	public NotaFicalBuilder emissao(String data) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		this.notaFiscal.setDataEmissao(sdf.parse(data));
		return this;
	}
	
	
	public NotaFiscal builder() {
		resolvedCalculaImposto()
		.calculaImposto(notaFiscal);
		
		return notaFiscal;
	}

	private NotaFiscalCalcula resolvedCalculaImposto() {
		if (this.notaFiscal.getCliente().getTipo().equals(PessoaTipo.PF)) {
			calcula =  new NotaFiscalPessoaFisicaCreator();
		} else {
			calcula =  new NotaFiscalPessoaJuridicaCreator();
		}
		return calcula;
	}

}
