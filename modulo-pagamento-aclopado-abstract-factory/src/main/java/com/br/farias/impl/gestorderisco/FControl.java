package com.br.farias.impl.gestorderisco;

import java.math.BigDecimal;

import com.br.farias.core.exceptions.AlertaDeRiscoException;
import com.br.farias.core.interfaces.GestorDeRisco;

public class FControl implements GestorDeRisco {
	
	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
		if (cartao.startsWith("7777")) 
			throw new AlertaDeRiscoException("Cartão suspeito.");
	}
}
