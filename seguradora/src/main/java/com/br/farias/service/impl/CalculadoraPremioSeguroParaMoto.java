package com.br.farias.service.impl;

import com.br.farias.service.CalculadoraPremioSeguro;

public class CalculadoraPremioSeguroParaMoto  implements CalculadoraPremioSeguro {

	private double perc = 0.45;
	
	@Override
	public double calcular(double valorVeiculo) {
		return valorVeiculo * perc;
	}

}
