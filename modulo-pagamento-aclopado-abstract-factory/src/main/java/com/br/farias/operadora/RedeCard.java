package com.br.farias.operadora;

import java.math.BigDecimal;

import com.br.farias.core.exceptions.CapturaNaoAutorizadaException;
import com.br.farias.core.interfaces.Operadora;

public class RedeCard implements Operadora {
	
	private Long codigoConfirmacao = -1L;

	public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException {
		if (cartao.startsWith("2222") && valorMaiorQueLimente(valor))
			throw new CapturaNaoAutorizadaException("Valor maior que limite para cartão informado.");
		this.codigoConfirmacao = (long) Math.random() * 300;
	}
	
	private boolean valorMaiorQueLimente(BigDecimal valor) {
		BigDecimal limite = new BigDecimal("1000");
		return valor.compareTo(limite) > 0;
	}

	public Long confirmar() {
		System.out.println("Fazendo debito na conta do cliente via RedeCard");
		return this.codigoConfirmacao;
	}

}
