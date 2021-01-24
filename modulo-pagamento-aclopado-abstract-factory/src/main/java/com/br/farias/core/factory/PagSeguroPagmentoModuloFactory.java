package com.br.farias.core.factory;

import com.br.farias.core.interfaces.GestorDeRisco;
import com.br.farias.core.interfaces.ModuloPagamentoFactory;
import com.br.farias.core.interfaces.Operadora;
import com.br.farias.gestorderisco.FControl;
import com.br.farias.operadora.Cielo;

public class PagSeguroPagmentoModuloFactory implements ModuloPagamentoFactory {

	public Operadora createOperadora() {
		return new Cielo() ;
	}

	public GestorDeRisco createGestorRisco() {
		return new FControl();
	}
}
