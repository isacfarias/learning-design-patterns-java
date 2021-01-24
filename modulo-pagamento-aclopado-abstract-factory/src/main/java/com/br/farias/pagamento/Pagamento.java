package com.br.farias.pagamento;

import java.math.BigDecimal;

import com.br.farias.core.exceptions.AlertaDeRiscoException;
import com.br.farias.core.exceptions.CapturaNaoAutorizadaException;
import com.br.farias.core.interfaces.GestorDeRisco;
import com.br.farias.core.interfaces.ModuloPagamentoFactory;
import com.br.farias.core.interfaces.Operadora;

public class Pagamento {
	
	private Operadora operadora;
	private GestorDeRisco gestorDeRisco;
		
	public Pagamento(ModuloPagamentoFactory factory) {
		this.operadora = factory.createOperadora();
		this.gestorDeRisco = factory.createGestorRisco();
	}
	
	public Long autorizar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		this.operadora.capturar(cartao, valor);
		this.gestorDeRisco.avaliarRisco(cartao, valor);
		return this.operadora.confirmar();
	}
	
}
