package com.br.farias.core.interfaces;

import java.math.BigDecimal;

import com.br.farias.core.exceptions.CapturaNaoAutorizadaException;

public interface Operadora {
	
	
	public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException;
	public Long confirmar();

}
