package com.br.farias.impl.gestorderisco;

import java.math.BigDecimal;

import com.br.farias.core.exceptions.AlertaDeRiscoException;
import com.br.farias.core.interfaces.GestorDeRisco;

public class ClearSale implements GestorDeRisco {

	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
		if (cartao.startsWith("1111") && valorMuitoAlto(valor)) 
			throw new AlertaDeRiscoException("Valor muito alto para este cartão.");
	}
	
	private boolean valorMuitoAlto(BigDecimal valor) {
		BigDecimal limite = new BigDecimal("5000");
		return limite.compareTo(valor) < 0;
	}

}
