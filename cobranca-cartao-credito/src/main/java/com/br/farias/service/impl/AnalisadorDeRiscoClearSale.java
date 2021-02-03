package com.br.farias.service.impl;

import java.time.YearMonth;

import com.br.farias.exception.RiscoCreditoException;
import com.br.farias.model.CartaoCredito;
import com.br.farias.model.Cliente;
import com.br.farias.service.AutorizadorCartaoCredito;

public class AnalisadorDeRiscoClearSale implements AutorizadorCartaoCredito {

	private AutorizadorCartaoCredito autorizador;
	
	public AnalisadorDeRiscoClearSale(AutorizadorCartaoCredito autorizador) {
		this.autorizador = autorizador;
	}

	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor) {
		if (cliente.getCpf().startsWith("111") || cartaoCredito.getVencimento().isBefore(YearMonth.now())
				|| valor > 500) {
			throw new RiscoCreditoException("Possível fraude, negando pagamento!");
		}
		
		autorizador.autorizar(cliente, cartaoCredito, valor);
	}

}