package com.br.farias.venda;

import com.br.farias.interfaces.Boleto;
import com.br.farias.interfaces.ModuloNotaFiscalEletronicaFactory;
import com.br.farias.interfaces.NotaFiscalEletronica;
import com.br.farias.model.NotaFiscal;

public class Venda {
	
	private NotaFiscalEletronica nfe;
	private Boleto boleto;
	
	public Venda(ModuloNotaFiscalEletronicaFactory loja) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		this.nfe    = loja.criarNfe();
		this.boleto = loja.criarBoleto();
	}
	
	
	public void finalizarVenda(NotaFiscal nf) {
		this.nfe.gerarNfe(nf);
		this.boleto.emitir(nf);
	}
	
}
