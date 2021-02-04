package com.br.farias.service;

import com.br.farias.model.Cliente;

public class PropostaSeguro {
	
	private CalculadoraPremioSeguro calculadora;
	private double valorVeiculo;
	private Cliente cliente;
	
	public PropostaSeguro(CalculadoraPremioSeguro calculadora) {
		this.calculadora = calculadora;
	}
	

	public void calcular(Cliente cliente, double valor) {
		this.cliente = cliente;
		this.valorVeiculo = valor;
	}
	
	public String gerar() {
		
		double vlr =  this.calculadora.calcular(valorVeiculo);
		
		return "Valor do premio  "+this.cliente.getNome()+" veiculo "+ this.cliente.getVeiculo()+" é de " + vlr;
	}

}
