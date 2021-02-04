package com.br.farias.service.impl;

import com.br.farias.service.Frete;

public class Normal implements Frete {

	public double calcularPreco(int distancia) {
		return distancia * 1.25 + 10;
	}

}
