package com.br.farias.core.interfaces;

import java.math.BigDecimal;

import com.br.farias.core.exceptions.AlertaDeRiscoException;

public interface GestorDeRisco {

	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException;
}
