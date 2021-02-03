package com.br.farias.service.impl;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.br.farias.model.CartaoCredito;
import com.br.farias.model.Cliente;
import com.br.farias.service.AutorizadorCartaoCredito;

public class AutorizadorCielo implements AutorizadorCartaoCredito {
	
	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor) {
		try (PrintStream writer = new PrintStream(new FileOutputStream("debitos.txt", true))) {
			writer.println(cliente + " | " + cartaoCredito + " | R$" + valor);
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Impossível salvar arquivo", e);
		}
	}

}