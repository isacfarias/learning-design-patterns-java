package com.br.farias.bean.impl;

import java.math.BigDecimal;

import com.br.farias.bean.CalculaImpostoService;

public class CalculaImpostoImpl implements CalculaImpostoService {

	@Override
	public BigDecimal calcular(BigDecimal valor) {
		return valor.multiply(new BigDecimal("0.15"));
	}

}
