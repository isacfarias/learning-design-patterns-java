package com.br.farias.service;

import com.br.farias.model.CartaoCredito;
import com.br.farias.model.Cliente;

public interface AutorizadorCartaoCredito {

	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor);

}