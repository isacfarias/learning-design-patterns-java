package com.br.farias.service.impl;

import com.br.farias.service.Frete;

public class Sedex implements Frete {
	
	public double calcularPreco(int distancia) {
		return distancia * 1.45 + 12;
	}

}
