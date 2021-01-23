package br.com.farias.impl;

import java.math.BigDecimal;

import br.com.farias.core.interfaces.NotaFiscalImpl;

public class NotaFiscalPessoaFisica implements NotaFiscalImpl {

	public BigDecimal imposto(BigDecimal valor) {
		return valor.subtract(valor.multiply(new BigDecimal("0.93")));
	}

}
