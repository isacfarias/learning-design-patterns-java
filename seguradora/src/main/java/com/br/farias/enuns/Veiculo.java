package com.br.farias.enuns;

import com.br.farias.service.CalculadoraPremioSeguro;
import com.br.farias.service.impl.CalculadoraPremioSeguroParaCarro;
import com.br.farias.service.impl.CalculadoraPremioSeguroParaMoto;

public enum Veiculo {
	
	MOTO {
		@Override
		public CalculadoraPremioSeguro obterVeiculo() {
			return new CalculadoraPremioSeguroParaMoto();
		}
	},
	
	CARRO {
		@Override
		public CalculadoraPremioSeguro obterVeiculo() {
			return new CalculadoraPremioSeguroParaCarro();
		}
	};
	
	public abstract CalculadoraPremioSeguro obterVeiculo();

}
