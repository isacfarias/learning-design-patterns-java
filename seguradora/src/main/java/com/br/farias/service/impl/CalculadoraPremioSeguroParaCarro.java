package com.br.farias.service.impl;

import com.br.farias.service.CalculadoraPremioSeguro;

public class CalculadoraPremioSeguroParaCarro  implements CalculadoraPremioSeguro {

	private double perc = 0.20;
	
	@Override
	public double calcular(double valorVeiculo) {
		return valorVeiculo * perc;
	}

}
